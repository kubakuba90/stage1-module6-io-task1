package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class FileReader {

    public static Profile getDataFromFile(File file)  { //throws IOException brak

        FileInputStream in = null;
        FileOutputStream out = null;
        StringBuilder dataFromFile = new StringBuilder();
        String stringWithProfile = "";

        try {
            in = new FileInputStream(file);
            int c;
            while ((c = in.read()) != -1) {
                dataFromFile.append((char) c);
                // read byte from file so its necessary to cast
                stringWithProfile += ((char) c);
            }
        } catch (IOException e) {
            System.out.println();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(stringWithProfile);

        String[] keyVals = stringWithProfile.split("[:\\n]");


            return new Profile(keyVals[1].trim(),
                    Integer.parseInt(keyVals[3].trim()),
                    keyVals[5].trim(),
                    Long.parseLong(keyVals[7].trim()));

    }
}

