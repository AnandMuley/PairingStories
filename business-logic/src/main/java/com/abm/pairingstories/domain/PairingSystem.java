package com.abm.pairingstories.domain;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.dao.Repository;
import com.abm.pairingstories.dao.ReviewerRepository;
import com.abm.pairingstories.dao.StoryRepository;
import com.abm.pairingstories.exceptions.NoStoryFoundException;
import com.abm.pairingstories.validators.ReviewerValidator;
import com.abm.pairingstories.validators.Validator;
import com.abm.pairingstories.view.StoryView;

public class PairingSystem {

    private AdvancedSet<Story> stories;
    private Repository<Story> repository;
    private Repository<Reviewer> reviewerRepository;
    private Story selectedStory;
    private Validator reviewerValidator;

    public PairingSystem() {
        this.reviewerRepository = new ReviewerRepository();
        this.repository = new StoryRepository();
        this.reviewerValidator = new ReviewerValidator(reviewerRepository);
        stories = repository.getAll();
    }

    public int getStoriesCount() {
        return stories.size();
    }

    public StoryView getStory(final int yearsOfExperience) throws NoStoryFoundException {
        return stories.find($ -> $.suitableForExperience(yearsOfExperience)).map($ -> {
            $.resetAllIterationsState();
            selectedStory = $;
            return StoryView.getInstance($);
        }).orElseThrow(NoStoryFoundException::new);
    }

    public void addStory(Story story) {
        Story savedStory = repository.save(story);
        stories.add(savedStory);
    }

    public StoryView reviewed(String reviewedBy) {
        reviewerValidator.isValid(reviewedBy).then(selectedStory::completedCurrentIteration).onErrorInThen(selectedStory::setCompleted);
        return StoryView.getInstance(selectedStory);
    }
}
