package org.streams;

public class JugarConsola {

            
    
    public static void main(String[] args) {
        
        Operacion op = (double x, double y) -> x + y;

        System.out.println("Suma: " + op.oper(1, 2));

        op = (x, y) -> x * y;

        System.out.println("Producto: "+op.oper(0, 0));

    }

}
