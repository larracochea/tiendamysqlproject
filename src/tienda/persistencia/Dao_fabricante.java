package tienda.persistencia;

import java.util.HashSet;
import java.util.Set;
import tienda.entidades.Fabricante;





public final class Dao_fabricante extends Dao {

public void GuardarFabricante(Fabricante fabricante) throws Exception{
  try{
      if (fabricante==null) {
          throw new Exception("debe tener un fabricante");
      }
      
      String sql= "INSERT INTO fabricante(codigo,nombre)"+
              " VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "' );";
      InsertarModificarEliminar(sql);
  }catch(Exception e){
      throw e;
  }
  
  
}
public void ModificarFabricante(Fabricante fabricante) throws Exception{
    
 try{
     if (fabricante==null) {
        throw new Exception("debe tener un fabricante");
     }
    
     String sql= "UPDATE fabricante SET" +
             "codigo= '" + fabricante.getCodigo() +     "' WHERE nombre = '" + fabricante.getNombre() + "' );";
 }catch(Exception e){
     throw e;
 }
}

}
