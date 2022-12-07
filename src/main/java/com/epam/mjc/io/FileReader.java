package com.epam.mjc.io;
import java.io.*;
public class FileReader {
    public static Profile getDataFromFile(File file) {

        String stringWithProfile = "";

        try (FileInputStream in = new FileInputStream(file);
                ) {
            int c;
            while ((c = in.read()) != -1) {
                stringWithProfile += ((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] keyVals = stringWithProfile.split("[:\\n]");

            return new Profile(keyVals[1].trim(),
                    Integer.parseInt(keyVals[3].trim()),
                    keyVals[5].trim(),
                    Long.parseLong(keyVals[7].trim()));
    }
}

