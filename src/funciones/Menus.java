package funciones;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menus {
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("\nSeleccione opción:"
                + "\n1.Calcular Cuotas de los socios"
                + "\n2.Exportar Datos a XML"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;  
        
    }
}
