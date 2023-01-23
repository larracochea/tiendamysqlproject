package tienda.servicios;

import java.util.Scanner;
import tienda.persistencia.Dao_producto;

public class Servicio_main {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Dao_producto daoProducto = new Dao_producto();
    Servicio_producto servicioProducto = new Servicio_producto();
    Servicio_fabricante servicioFabricante = new Servicio_fabricante();

    public void Menu() throws Exception {
        String nombre;
        Double precio;
        int codigoFabricante;
        System.out.println("ingresando a la tabla de la tienda");
        bucleMenu:
        try {
            do {
                System.out.println("ingrese que desea hacer");
                System.out.println("1)listado de todos los productos por nombre" + "\n"
                        + "2)nombres y precios de todos los productos" + "\n"
                        + "3)productos con un precio entre 120 y 202" + "\n"
                        + "4)portatiles en la tabla producto" + "\n"
                        + "5)nombre y precio del producto mas barato" + "\n"
                        + "6)ingresar un producto a la base de datos" + "\n"
                        + "7)ingresar un fabricante a la base de datos" + "\n"
                        + "8)editar un producto" + "\n"
                        + "9)terminar operacion");
                switch (Integer.valueOf(leer.next())) {
                    case 1:
                        System.out.println(daoProducto.listaProductoNombre());
                        break;
                    case 2:
                        System.out.println(daoProducto.listaProductoNombrePrecio());
                        break;
                    case 3:
                        System.out.println(daoProducto.EncontrarEntre());
                        break;
                    case 4:
                        System.out.println(daoProducto.ListaPortatiles());
                        break;
                    case 5:
                        System.out.println(daoProducto.EncontrarMasBarato());
                        break;
                    case 6:
                        System.out.println("ingrese los datos del nuevo producto");
                        System.out.println("nombre");
                        nombre=leer.next();
                        System.out.println("precio");
                        precio=leer.nextDouble();
                        System.out.println("codigo de fabricante");
                        codigoFabricante=leer.nextInt();
                        servicioProducto.crearProducto(nombre, precio, codigoFabricante);
                        break;
                    case 7:
                        System.out.println("ingrese los datos del fabricante");
                        nombre=leer.next();
                        codigoFabricante=leer.nextInt();
                        servicioFabricante.crearFabricante(codigoFabricante, nombre);
                        break;
                    case 8:
                        servicioProducto.ModificarProducto();
                        break;
                    case 9:
                        break bucleMenu;
                    default:
                        System.out.println("ingrese un dato valido");

                }

            } while (true);
        } catch (Exception e) {
            System.out.println("ingrese datos validos");
            throw e;
        }
    }

}
