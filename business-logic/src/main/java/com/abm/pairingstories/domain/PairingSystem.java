package com.abm.pairingstories.domain;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.dao.Repository;
import com.abm.pairingstories.dao.StoryRepository;
import com.abm.pairingstories.exceptions.NoStoryFoundException;
import com.abm.pairingstories.view.StoryView;

public class PairingSystem {

    private AdvancedSet<Story> stories;
    private Repository<Story> repository;

    public PairingSystem() {
        this.repository = new StoryRepository();
        stories = repository.getAll();
    }

    public int getStoriesCount() {
        return stories.size();
    }

    public StoryView getStory(final int yearsOfExperience) throws NoStoryFoundException {
        return stories.find($ -> $.suitableForExperience(yearsOfExperience)).map(StoryView::getInstance).orElseThrow(NoStoryFoundException::new);
    }

    public void addStory(Story story) {
        Story savedStory = repository.save(story);
        stories.add(savedStory);
    }
}