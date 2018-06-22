package com.abm.pairingstories.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class HtmlFile {

    private Path path;
    private StoryName storyName;

    public HtmlFile(Path path) {
        this.path = path;
    }

    public String readFileContent() {
        try {
            return Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getName() {
        return path.getFileName().toString();
    }

    public Path getIterationsPath() {
        storyName = new StoryName(getName());
        return Paths.get(path.getParent().toString() + File.separator + storyName.getIterationsFolderName());
    }


}
