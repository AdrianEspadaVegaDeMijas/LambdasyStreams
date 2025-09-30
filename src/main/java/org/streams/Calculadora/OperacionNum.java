package org.streams.Calculadora;

import java.util.Map;
import java.util.function.Predicate;

public interface OperacionNum {

    public String transforma(String str);

    public static boolean test (String[] instruccionArr, Predicate<Integer> pred) {

        int num = Integer.parseInt(instruccionArr[0]);

        boolean resultado = pred.test(num);

        return resultado;

    }
    
}
