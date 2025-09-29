package org.streams.Calculadora;

import java.util.Map;

public class Validar {

    public static boolean validarStr(String[] instruccionArr, Map<String, OperacionStr> operaciones) {


        if(operaciones.containsKey(instruccionArr[0])) {
            


            return true;

        } else {

            System.out.println("Operacion '"+ instruccionArr[0] + "' no contemplada");
            return false;
        }

    }
    
    public static boolean validar(String[] instruccionArr, Map<String, Operacion> mapOperaciones) {


        //valida que la cantidad de parametros sea correcta
        if (instruccionArr.length != 3) {

            System.out.println("Número de parámetros incorrecto");
            return false;
            
        }

        //valida que la operacion este contemplada
        if(!mapOperaciones.containsKey(instruccionArr[0])) {

            System.out.println("Operacion '"+ instruccionArr[0] + "' no contemplada");
            return false;

        }

        //valida que los operandos no esten vacios
        if(instruccionArr[1].isEmpty() || instruccionArr[2].isEmpty()) {

            System.out.println("Faltan operandos");
            return false;

        }


        //valida que los operandos sean numeros
        try {
            Double.parseDouble(instruccionArr[1]);
            Double.parseDouble(instruccionArr[2]);

            //Confirmamos que no se intente dividir por 0
            if(instruccionArr[0].equals("/") || instruccionArr[0].equals("div") &&  Double.parseDouble(instruccionArr[2]) == 0) {
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
