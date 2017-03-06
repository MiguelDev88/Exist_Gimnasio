package funciones;
import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Consultas {
    
    public static void consultaCuota (Collection col , BufferedReader leer) throws IOException, XMLDBException {
        
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        
        ResourceSet result=servicio.query("for $socio in /Socios/socio "
                                        + "let $codigo := $socio/@codigo "
                                        + "let $cuota := $socio/cuota "
                                        + "for $actividad in /Actividades/actividad[@codigo=$codigo] "
                                        + "let $cuota_fin := sum()"
                                        + "   ");
        ResourceIterator i = result.getIterator();
        
        
        
        
        
        
        
        
    }
    
    public static void exportarDatos (Collection col , BufferedReader leer) throws IOException, XMLDBException {
        
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        
        
        
        
        
        
        
        
    }

}
