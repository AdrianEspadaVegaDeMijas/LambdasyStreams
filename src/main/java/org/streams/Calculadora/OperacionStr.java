package org.streams;

import java.util.Map;

public interface OperacionStr {
 
    // s -> s.toUpperCase()

    public String transforma(String str);

    public static void calcularStr (String[] instruccionArr, Map<String, OperacionStr> mapOperacionesStr) {
        
        if(instruccionArr[0].equals("trim")) {
        
        }

        System.out.println(mapOperacionesStr.get(instruccionArr[0]).transforma(instruccionArr[1]));

    }
    
}