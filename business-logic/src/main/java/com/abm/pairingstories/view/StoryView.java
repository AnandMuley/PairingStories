package com.abm.pairingstories.view;

import com.abm.pairingstories.domain.Story;

public class StoryView {

    private String name;
    private String description;
    private IterationView currentIteration;

    private StoryView(Story story) {
        this.name = story.getName();
        this.description = story.getDescription();
        this.currentIteration = new IterationView(story.getCurrentIteration());
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

    public IterationView getCurrentIteration() {
        return currentIteration;
    }

    @Override
    public String toString() {
        return "StoryView{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
