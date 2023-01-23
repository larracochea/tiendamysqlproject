package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Dao {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void ConectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String URLBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(URLBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void DesconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void InsertarModificarEliminar(String sql) throws Exception {
        try {
            ConectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (Exception e) {
            //conexion.rollback();
            /*
     in case of rollback you can uncoment the last line
     it does work without rollback
     run the next script on workbench
     Set autocommit=1;
     COMMIT;    
             */
            throw e;
        } finally {
            DesconectarBase();
        }
    }

    protected void ConsultarBase(String sql) throws Exception {
        try {
            ConectarBase();
            sentencia = conexion.createStatement();
            resultado= sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
