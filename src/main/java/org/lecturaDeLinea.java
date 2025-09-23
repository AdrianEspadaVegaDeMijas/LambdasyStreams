package org;

import java.io.IOException;

public class lecturaDeLinea {
    
    public static void main(String[] args) throws IOException {

        int c;
        int contador = 0;

        while ((c = System.in.read()) != '\n') {

            contador++;

            System.out.print((char) c);

        }

        System.out.println("");
        System.out.println("Leidos " + contador + " caracteres");

    }

}
