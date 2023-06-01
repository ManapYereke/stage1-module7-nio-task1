package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.HashMap;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Path filePatch = file.toPath();
        try {
            Map<String, String> fd = new HashMap<>();
            Files.lines(filePatch, StandardCharsets.UTF_8).forEach(line -> {
                String[] str = line.split(":");
                if (str.length == 2)
                    fd.put(str[0].trim(), str[1].trim());
            });
            String name = fd.get("Name");
            int age = Integer.parseInt(fd.get("Age"));
            String email = fd.get("Email");
            long phone = Long.parseLong(fd.get("Phone"));
            System.out.println(".close()");
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
