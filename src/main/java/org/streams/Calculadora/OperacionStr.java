package org.streams.Calculadora;

import java.util.Arrays;
import java.util.Map;

public interface OperacionStr {
 
    // s -> s.toUpperCase()

    public String transforma(String str);

    public static void calcularStr (String[] instruccionArr, Map<String, OperacionStr> mapOperacionesStr) {
        
        if(instruccionArr[0].equals("reverse")) {

            String[] arr = Arrays.copyOfRange(instruccionArr, 1, instruccionArr.length);

            String res = String.join( " ", arr);

            System.out.println(mapOperacionesStr.get(instruccionArr[0]).transforma(res));
        
            return;
        }

        System.out.println(mapOperacionesStr.get(instruccionArr[0]).transforma(instruccionArr[1]));

    }
    
}