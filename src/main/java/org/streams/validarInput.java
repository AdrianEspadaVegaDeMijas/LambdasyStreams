package org.streams;

import java.util.List;

public class validarInput {
    
    public static boolean validar(String[] instruccionArr) {

        List<String> operaciones = List.of("+", "add", "-", "sub", "*", "mul", "/", "div");

        //valida que la cantidad de parametros sea correcta
        if (instruccionArr.length != 3) {

            System.out.println("Número de parámetros incorrecto");
            return false;
            
        }

        //valida que la operacion este contemplada
        if(operaciones.contains(instruccionArr[0]) == false) {

            System.out.println("Operacion '"+ instruccionArr[0] + "' no contemplada");
            return false;

        }

        //valida que los operandos no esten vacios
        if(instruccionArr[1].isEmpty() == true || instruccionArr[2].isEmpty() == true) {

            System.out.println("Faltan operandos");
            return false;

        }


        //valida que los operandos sean numeros
        try {
            Double.parseDouble(instruccionArr[1]);
            Double.parseDouble(instruccionArr[2]);

            //Confirmamos que no se intente dividir por 0
            if(instruccionArr[0].equals("/") || instruccionArr[0].equals("div") &&  instruccionArr[2].equals("0")) {
                System.out.println("No se puede dividir por 0");
                return false;
            }

            return true; // Es un número válido
        } catch (NumberFormatException e) {
            System.out.println("Formato de parámetro incorrecto");
            return false; // No es un número
        }
    }
}
