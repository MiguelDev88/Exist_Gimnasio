/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funciones;

import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Modificar {
    
    public static void modificar (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        int dep;
        
        
        System.out.println("Introducir número de departamento a dar de baja:");
        dep=Integer.parseInt(leer.readLine());
        
        ResourceSet result=servicio.query("for $dep in /departamentos/departamento[numero = "+dep+"] return $dep");
        ResourceIterator i = result.getIterator();
        
        if(!i.hasMoreResources())
            System.out.println("No existe ningún departamento con ese número.");
        else{
            modificarDepartamento(servicio, leer, dep);
        }  
    }
    
    public static void modificarDepartamento (XPathQueryService servicio, BufferedReader leer, int dep) throws XMLDBException, IOException {
        
        byte op=0;
        String nombre, localizacion;
        
        switch (op){
            case 1:
                System.out.println("Introducir nuevo nombre:");
                nombre=leer.readLine();
                servicio.query("update replace /departamentos/departamento[numero="+dep+"]/nombre with <nombre>"+nombre+"</nombre>");
                break;
            case 2:
                System.out.println("Introducir nueva localización:");
                localizacion=leer.readLine();
                servicio.query("update replace /departamentos/departamento[numero="+dep+"]/localizacion with <localizacion>"+localizacion+"</localizacion>");
                break;
        }
    }
}
