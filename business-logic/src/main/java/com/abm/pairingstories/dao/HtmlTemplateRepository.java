package com.abm.pairingstories.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Iteration;
import com.abm.pairingstories.domain.Story;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HtmlTemplateRepository {

    private static String resourceLocation = "/home/andriox/projects/business/PairingStories/business-logic/src/main/resources/";

    private StoryName storyName;

    public HtmlTemplateRepository() {
    }

    public String load(String name) {
        String result = null;
        try {
            result = Files.readAllLines(Paths.get(resourceLocation + name)).stream().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private SortedSet<Iteration> loadIterations(HtmlFile htmlFile, String storyName) {
        Path iterationPath = htmlFile.getIterationsPath();
        try {
            return Files.list(iterationPath).sorted()
                    .map(HtmlFile::new)
                    .map($ -> new Iteration.Builder($.readFileContent()).build())
                    .collect(Collectors.toCollection(TreeSet::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptySortedSet();
    }

    public AdvancedSet<Story> loadData() {
        AdvancedSet<Story> stories = new AdvancedSet<>();
        try {
            Files.list(Paths.get(resourceLocation))
                    .filter($ -> $.toFile().isFile())
                    .map(HtmlFile::new)
                    .forEach(
                            htmlFile -> {
                                storyName = new StoryName(htmlFile.getName());
                                String storyNameStr = storyName.getValueFromFilename();
                                Story story = new Story.Builder(storyNameStr, htmlFile.readFileContent(),
                                        storyName.getExperienceRange(), loadIterations(htmlFile, storyNameStr)).build();
                                stories.add(story);
                            }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stories;
    }
}
