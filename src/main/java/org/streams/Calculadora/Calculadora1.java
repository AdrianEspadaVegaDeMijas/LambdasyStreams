package org.streams.Calculadora;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

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

        //operacion Num






        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean salir = false;

        while(!salir){
            
            //convertimos el input en un Ararray
            String[] instruccionArr = input.trim().split(" ");

            //Valido input y hago la operacion correspondiente.
            if(Validar.validarStr(instruccionArr, mapOperacionesStr)) {

                OperacionStr.calcularStr(instruccionArr, mapOperacionesStr);

            //Valida un solo numero
            }else if(Validar.validarNum(instruccionArr)) {

                Predicate<Integer> predicadoPar = (num) -> num % 2 == 0;
                Predicate<Integer> predicadoMul5 = (num) -> num % 5 == 0;
                Predicate<Integer> predicado10a100 = (num) -> num>10 && num<100;
                Predicate<Integer> predicadoPrimo = num -> {
                    if (num < 2) return false; // los números menores que 2 no son primos
                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) return false; // si es divisible, no es primo
                    }
                    return true; // si no se encontró divisor, es primo
                };

                OperacionNum.test(instruccionArr, predicadoPar);
                OperacionNum.test(instruccionArr, predicadoMul5);
                OperacionNum.test(instruccionArr, predicado10a100);
                OperacionNum.test(instruccionArr, predicadoPrimo);

                if(OperacionNum.test(instruccionArr, predicadoPar)) {
                    System.out.println("Es par");
                }
                if(OperacionNum.test(instruccionArr, predicadoMul5)) {
                    System.out.println("Es multiplo de 5");
                }
                if(OperacionNum.test(instruccionArr, predicado10a100)) {
                    System.out.println("Esta entre 10 y 100");
                }
                if(OperacionNum.test(instruccionArr, predicadoPrimo)) {
                    System.out.println("Es primo");
                }

            //Valida una operacion
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
