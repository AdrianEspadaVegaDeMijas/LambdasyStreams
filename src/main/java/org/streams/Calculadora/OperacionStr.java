package org.streams.Calculadora;

import java.util.Arrays;
import java.util.Map;

public interface OperacionStr {
 
    // s -> s.toUpperCase()

    public String transforma(String str);

    public static void calcularStr (String[] instruccionArr, Map<String, OperacionStr> mapOperacionesStr) {

        //Coge los parametros que haya despues de la posicion 0 del arrays y los junta en un mismo string
        String[] arr = Arrays.copyOfRange(instruccionArr, 1, instruccionArr.length);

        String res = String.join( " ", arr);

        System.out.println(mapOperacionesStr.get(instruccionArr[0]).transforma(res));

    }
    
}