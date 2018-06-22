package com.abm.pairingstories.view;

import com.abm.pairingstories.domain.Story;
import com.abm.pairingstories.exceptions.NoPendingIterationException;

public class StoryView {

    private String name;
    private String description;
    private IterationView currentIteration;
    private boolean completed;

    private StoryView(Story story) {
        this.name = story.getName();
        this.description = story.getDescription();
        try {
            this.currentIteration = new IterationView(story.getCurrentIteration());
        } catch (NoPendingIterationException e) {
            completed = true;
        }
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
