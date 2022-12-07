package com.epam.mjc.io;

import java.io.*;
public class FileReader {

    public static Profile getDataFromFile(File file) {

        StringBuilder dataFromFile = new StringBuilder();
        String stringWithProfile = "";

        try (FileInputStream in = new FileInputStream(file);
                ) {
            //in = new FileInputStream(file);
            int c;
            while ((c = in.read()) != -1) {
                dataFromFile.append((char) c);
                // read byte from file so its necessary to cast
                stringWithProfile += ((char) c);
            }
        } catch (IOException e) {

        }

        String[] keyVals = stringWithProfile.split("[:\\n]");

            return new Profile(keyVals[1].trim(),
                    Integer.parseInt(keyVals[3].trim()),
                    keyVals[5].trim(),
                    Long.parseLong(keyVals[7].trim()));
    }
}

