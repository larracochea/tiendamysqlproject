package tienda.servicios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import tienda.entidades.Producto;
import tienda.persistencia.Dao_producto;

public class Servicio_producto {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Dao_producto daoProducto = new Dao_producto();

    public void ModificarProducto() throws Exception {
        try {
            System.out.println("ingrese el codigo del producto que va a modificar");
            System.out.println(daoProducto.ListaProducto());
            int num = leer.nextInt();
            Producto producto = daoProducto.CopiarProducto(num);
            System.out.println("desea cambiar el codigo? 1 para confirmar");
            if (Integer.valueOf(leer.next()) == 1) {
                System.out.println("ingrese el nuevo codigo");
                int codigo = leer.nextInt();
                if (daoProducto.existeProd(codigo) != null) {
                    throw new Exception("El codigo " + codigo + " ya esta registrado.");
                }
                producto.setCodigo(codigo);
            }
            System.out.println("desea cambiar el nombre? 1 para confirmar");
            if (Integer.valueOf(leer.next()) == 1) {
                producto.setNombre(leer.next());
            }
            System.out.println("desea cambiar el precio? 1 para confirmar");
            if (Integer.valueOf(leer.next()) == 1) {
                producto.setPrecio(leer.nextDouble());
            }
            System.out.println("desea cambiar el codigo de fabricante? 1 para confirmar");
            if (Integer.valueOf(leer.next()) == 1) {
                producto.setCodigoFabricante(leer.nextInt());
            }
            daoProducto.ModificarProducto(producto, num);
        } catch (Exception e) {
            System.out.println("ingrese datos validos");
            throw e;
        }
    }
    
    public void crearProducto(String nombre, Double precio, Integer codigo_fabricante) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe indicar un nombre");
        }
        if (precio <= 0 || precio.toString() == null || precio.toString().trim().isEmpty()) {
            throw new Exception("Debe indicar el precio");
        }
        if (codigo_fabricante <= 0 || codigo_fabricante.toString() == null || codigo_fabricante.toString().trim().isEmpty()) {
            throw new Exception("Debe indicar un codigo de fabricante valido");
        }

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCodigoFabricante(codigo_fabricante);

        daoProducto.GuardarProducto(producto);
    }
    
}
