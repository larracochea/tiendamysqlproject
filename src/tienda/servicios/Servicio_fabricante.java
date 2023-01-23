package tienda.servicios;





public class Servicio_fabricante {
    
    public void crearFabricante (Integer codigo, String nombre) throws Exception{
        
        try {
                if(codigo == null){
                    throw new Exception("No pusiste codigo");
                }
                if(nombre == null){
                    throw new Exception("No pusiste nombre.");
                }
        } catch (Exception e) {
            throw e;
        }
            
        
    }

}
