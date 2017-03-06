package exist_gimnasio;
import funciones.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.xmldb.api.base.Collection;

/**
 *
 * @author Miguel
 */
public class Exist_Gimnasio {

    public static void main(String[] args) throws ClassNotFoundException {
        
        byte op;
        BufferedReader leer = new BufferedReader (new InputStreamReader (System.in));
        
        try{
            Collection col = CrearBD.crearBD();
            
            do{ 
                op=Menus.menuConsultas(leer);
                switch(op){
                    case 1:
                        Consultas.consultaCuota(col, leer);
                        break;
                    case 2:
                        Consultas.exportarDatos(col, leer);
                        break;
                    case 0:
                        System.out.println("\n - FIN DEL PROGRAMA - \n");
                        System.exit(0);
                    }
            }while(op!=0); 
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    
}
