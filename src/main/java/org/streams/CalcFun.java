package org.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcFun {

    private static Map<String, Operacion> mapOperaciones = new HashMap<>();

    
    public static void main(String [] args) {

        Operacion suma= ((x, y) -> x + y);
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

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean salir = false;

        while(!salir){
            
            //convertimos el input en un Ararray
            String[] instruccionArr = input.trim().split(" ");

            //Valido input y hago la operacion correspondiente.
            if(validarInput.validar(instruccionArr) == true) {

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
