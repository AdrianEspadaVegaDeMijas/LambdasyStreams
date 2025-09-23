package org;

import java.io.BufferedReader;
import java.io.FileReader;

public class lecturaReader {

    public static void main(String[] args) {
        try {

            // Crea un FileReader
            FileReader file = new FileReader("/home/adrian/workspace/lamdas_streams/input.txt");

            // Wrapeas (envuelves) el FileReader en un BufferedReader
            BufferedReader input = new BufferedReader(file);

            // Lees el primer byte
            int i = input.read();

            while (i != -1) {
                System.out.print((char) i);

                // Lee el siguiente byte
                i = input.read();
            }
            input.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
