package com.abm.pairingstories.domain;

import com.abm.pairingstories.domain.exceptions.NoStoryFoundException;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.abm.pairingstories.domain.ExperienceRange.between;

public class PairingSystem {

    private Set<Story> stories;

    public PairingSystem() {
        Story syntaxHighlighter = new Story("Syntax Highlighter", between(0, 3));
        Story carRental = new Story("Car Rental", between(3, 5));
        stories = new LinkedHashSet<>();
        stories.add(syntaxHighlighter);
        stories.add(carRental);
    }

    public int getStoriesCount() {
        return stories.size();
    }

    public Story getStory(final int yearsOfExperience) throws NoStoryFoundException {
        return stories.stream()
                .filter($ -> $.suitableForExperience(yearsOfExperience))
                .findAny()
                .orElseThrow(NoStoryFoundException::new);
    }

    public void addStory(Story story) {
        stories.add(story);
    }
}
