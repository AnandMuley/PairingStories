package com.abm.pairingstories.view;

import com.abm.pairingstories.domain.Story;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StoryView {

    private String name;
    private String description;
    private Set<IterationView> iterations;
    private boolean completed;

    private StoryView(Story story) {
        this.name = story.getName();
        this.description = story.getDescription();
        this.iterations = story.getIterations().stream().peek($ -> story.setCompleted($.isCompleted())).map(IterationView::new).collect(Collectors.toCollection(TreeSet::new));
        this.completed = story.isCompleted();
    }

    public static StoryView getInstance(Story story) {
        return new StoryView(story);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Set<IterationView> getIterations() {
        return iterations;
    }

    @Override
    public String toString() {
        return "StoryView{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
