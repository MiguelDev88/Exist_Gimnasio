package funciones;
import java.io.File;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.modules.CollectionManagementService;


// @author Miguel

public class CrearBD {
    
    public static Collection crearBD () {
        
        Resource newResource;
        Collection col=null;
        File socios = new File("xml/socios_gim.xml");
        File actividades = new File("xml/actividades_gim.xml");
        File usos = new File("xml/uso_gimnasio.xml");
        
        try{
            String driver="org.exist.xmldb.DatabaseImpl";
            Class c=Class.forName(driver);
            Database db= (Database)c.newInstance();
            DatabaseManager.registerDatabase(db);
            String uri="xmldb:exist://localhost:8080/exist/xmlrpc/db";
            String usu="admin";
            String psw="admin";
            
            col = DatabaseManager.getCollection(uri,usu,psw);
            
            if(col.getChildCollection("Gimnasio") == null){
                CollectionManagementService service=(CollectionManagementService) col.getService("CollectionManagementService","1.0");
                service.createCollection("Gimnasio");
                col=col.getChildCollection("Gimnasio");
                newResource = col.createResource(socios.getName(),"XMLResource");
                newResource.setContent(socios);
                col.storeResource(newResource);

                newResource = col.createResource(actividades.getName(),"XMLResource");
                newResource.setContent(actividades);
                col.storeResource(newResource);

                newResource = col.createResource(usos.getName(),"XMLResource");
                newResource.setContent(usos);
                col.storeResource(newResource);
            }
            
            return col;
            
        }catch(Exception e){
            System.out.println("Error de conexión con la BD");
        }
        
        return col;
    }
}
