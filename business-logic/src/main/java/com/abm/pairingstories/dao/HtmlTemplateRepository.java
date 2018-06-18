package com.abm.pairingstories.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class HtmlTemplateRepository {

    private String resourceLocation = "/home/andriox/projects/business/PairingStories/business-logic/src/main/resources/";

    public String load(String name) {
        String result = null;
        try {
            result = Files.readAllLines(Paths.get(resourceLocation + name)).stream().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
