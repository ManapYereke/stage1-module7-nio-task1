package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try {
            Path filePath = file.toPath();
            BufferedReader reader = Files.newBufferedReader(filePath);
            String name = reader.readLine().split(":")[1].trim();
            int age = Integer.parseInt(reader.readLine().split(":")[1].trim());
            String email = reader.readLine().split(":")[1].trim();
            long phone = Long.parseLong(reader.readLine().split(":")[1].trim());
            reader.close();
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
