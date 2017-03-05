package funciones;
import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Consultas {
    
    public static void bajas (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        int dep;
        
        
        System.out.println("Introducir número de departamento a buscar:");
        dep=Integer.parseInt(leer.readLine());
        
        ResourceSet result=servicio.query("for $dep in /departamentos/departamento[numero = "+dep+"] return $dep");
        ResourceIterator i = result.getIterator();
        
        if(!i.hasMoreResources())
            System.out.println("No existe ningún departamento con ese número.");
        else{
            
            System.out.println("");
            //lo tengo!!
        }  
    }

}
