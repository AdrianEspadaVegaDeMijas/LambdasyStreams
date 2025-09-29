package org.streams.Calculadora;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora1 {

    private static Map<String, Operacion> mapOperaciones = new HashMap<>();

    private static Map<String, OperacionStr> mapOperacionesStr = new HashMap<>();

    
    public static void main(String [] args) {

        //Operacines Numeros

        Operacion suma = ((x, y) -> x + y);
        Operacion resta = ((x, y) -> x - y);
        Operacion mult = ((x, y) -> x * y);
        Operacion div = ((x, y) -> x / y);

        mapOperaciones.put("+", suma);
        mapOperaciones.put("add", suma);

        mapOperaciones.put("-", resta);
        mapOperaciones.put("sub", resta);

        mapOperaciones.put("mul", mult);
        mapOperaciones.put("*", mult);

        mapOperaciones.put("/", div);
        mapOperaciones.put("div", div);

        //operaciones Strings

        OperacionStr upper = (s -> s.toUpperCase());
        OperacionStr lower = (s -> s.toLowerCase());
        OperacionStr reverse = (s -> new StringBuilder(s).reverse().toString());
        OperacionStr length = (s -> String.valueOf(s.length()));
        OperacionStr trim = (s -> s.trim());

        mapOperacionesStr.put("upper", upper);
        mapOperacionesStr.put("lower", lower);
        mapOperacionesStr.put("reverse", reverse);
        mapOperacionesStr.put("length", length);
        mapOperacionesStr.put("trim", trim);


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean salir = false;

        while(!salir){
            
            //convertimos el input en un Ararray
            String[] instruccionArr = input.trim().split(" ");

            //Valido input y hago la operacion correspondiente.
            if(Validar.validarStr(instruccionArr, mapOperacionesStr)) {

                OperacionStr.calcularStr(instruccionArr, mapOperacionesStr);

            }else if(Validar.validar(instruccionArr, mapOperaciones)) {

                Operacion.calcular(instruccionArr, mapOperaciones);

            }
            
            //Pido nuevo input
            input = sc.nextLine();

            //Condicion de salida
            salir = input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("salir");

        }

        sc.close();

    }



    

}
