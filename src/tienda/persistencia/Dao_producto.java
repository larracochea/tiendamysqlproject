package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import tienda.entidades.Producto;

public final class Dao_producto extends Dao {

    public void GuardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("debe tener un producto");
            }

            String sql = "INSERT INTO producto(codigo,nombre,precio,codigo_fabricante)"
                    + " VALUES ( " + producto.getCodigo() + " , '" + producto.getNombre() + "' , " + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " );";
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }

    }

    public void ModificarProducto(Producto producto, int codigoViejo) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE producto SET"
                    + " codigo = " + producto.getCodigo() + " ,nombre = '" + producto.getNombre() + "' , precio = " + producto.getPrecio() + " , codigo_fabricante = " + producto.getCodigoFabricante()
                    + " WHERE codigo = " + codigoViejo
                    + " ;";
            InsertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto EncontrarMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto" + " WHERE precio = " + "(SELECT MIN(precio) FROM producto)";
            ConsultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            DesconectarBase();
            return producto;
        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listaProductoNombrePrecio() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM producto";

            ConsultarBase(sql);

            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                lista.add(producto);
            }
            DesconectarBase();
            return lista;

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> listaProductoNombre() throws Exception {

        try {
            String sql = "SELECT nombre FROM producto";

            ConsultarBase(sql);

            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                lista.add(producto);
            }
            DesconectarBase();
            return lista;

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> ListaPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto" + " WHERE nombre LIKE '%Portátil%'";

            ConsultarBase(sql);

            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(4);
                lista.add(producto);
            }
            return lista;
        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }

    public Collection<Producto> EncontrarEntre() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            ConsultarBase(sql);
            Producto producto = null;
            Collection<Producto> lista = new ArrayList();

            while (resultado.next()) {

                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));

                lista.add(producto);

            }
            DesconectarBase();
            return lista;
        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }
    }

    public Integer existeProd(int codigo) throws Exception {

        try {

            String sql = " SELECT codigo FROM producto WHERE codigo = " + codigo + ";";

            ConsultarBase(sql);
            Integer existe = null;

            while (resultado.next()) {
                existe = resultado.getInt(1);
            }
            DesconectarBase();
            return existe;

        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }

    }

    public Collection<Producto> ListaProducto() throws Exception {

        try {
            String sql = "SELECT * FROM producto";

            ConsultarBase(sql);

            Producto producto = null;
            Collection<Producto> lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                lista.add(producto);
            }
            DesconectarBase();
            return lista;

        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }

    }
    
    public Producto CopiarProducto(int codigo) throws Exception {

        try {

            String sql = " SELECT * FROM producto WHERE codigo = " + codigo + ";";

            ConsultarBase(sql);
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            DesconectarBase();
            return producto;

        } catch (Exception e) {
            DesconectarBase();
            throw e;
        }

    }
}
