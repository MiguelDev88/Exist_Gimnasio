/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funciones;

import java.io.BufferedReader;
import java.io.IOException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;


// @author Miguel

public class Altas {
    
    public static void altas (XPathQueryService servicio, BufferedReader leer) throws IOException {
        
        byte op=1;

        while(op!=0){
            op=Menus.menuAltas(leer);
            switch(op){
                case 1:
                    //altaSocio(leer);
                    break;
                case 2:
                    //altaActividad(leer);
                    break;
                case 3:
                    //altaUso(leer);
                    break;
            }
        }
    }
    
    public static void altaSocio (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        String dni, nombre, localizacion;
        
        
        System.out.println("Introducir DNI del socio:");
        dni=leer.readLine();
        
        ResourceSet result=servicio.query("for $socio in /socios/socio[dni = "+dni+"] return $socio");
        
        ResourceIterator i = result.getIterator();
        
        if(i.hasMoreResources())
            System.out.println(" - Ya existe un socio con ese dni.");
        else{
            System.out.println("Introducir nombre del socio:");
            nombre=leer.readLine();
            System.out.println("Introducir localización:");
            localizacion=leer.readLine();
            /*
            servicio.query("update insert"
                    + "<departamento>"
                    + "<numero>"+dep+"</numero>"
                    + "<nombre>"+nombre+"</nombre>"
                    + "<localizacion>"+localizacion+"</localizacion>"
                    + "</departamento>"
                    + "into /departamentos");
            */
            System.out.println(" - Departamento Registrado - ");
        }  
    }
    
    public static void altaActividad (XPathQueryService servicio , BufferedReader leer) throws IOException, XMLDBException {
        
        String dni, nombre, localizacion;
        
        
        System.out.println("Introducir DNI del socio:");
        dni=leer.readLine();
        
        ResourceSet result=servicio.query("for $socio in /socios/socio[dni = "+dni+"] return $socio");
        
        ResourceIterator i = result.getIterator();
        
        if(i.hasMoreResources())
            System.out.println(" - Ya existe un socio con ese dni.");
        else{
            System.out.println("Introducir nombre del socio:");
            nombre=leer.readLine();
            System.out.println("Introducir localización:");
            localizacion=leer.readLine();
            /*
            servicio.query("update insert"
                    + "<departamento>"
                    + "<numero>"+dep+"</numero>"
                    + "<nombre>"+nombre+"</nombre>"
                    + "<localizacion>"+localizacion+"</localizacion>"
                    + "</departamento>"
                    + "into /departamentos");
            */
            System.out.println(" - Departamento Registrado - ");
        }  
    }

}
