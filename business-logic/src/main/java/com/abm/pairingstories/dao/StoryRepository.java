package com.abm.pairingstories.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Story;

import java.util.Arrays;

import static com.abm.pairingstories.domain.ExperienceRange.between;

public class StoryRepository implements Repository<Story> {

    private AdvancedSet<Story> stories;
    private HtmlTemplateRepository htmlTemplateRepository;

    public StoryRepository() {
        stories = new AdvancedSet<>();
        htmlTemplateRepository = new HtmlTemplateRepository();
        Story syntaxHighlighter = new Story("Syntax Highlighter", htmlTemplateRepository.load("SyntaxHighlighter.html"), between(0, 3));
        Story carRental = new Story("Car Rental", htmlTemplateRepository.load("CarRental.html"), between(3, 5));
        Story cardGame = new Story("Card Game", htmlTemplateRepository.load("CardGame.html"), between(5, 10));
        stories.addAll(Arrays.asList(syntaxHighlighter, carRental, cardGame));
    }

    @Override
    public AdvancedSet<Story> getAll() {
        return stories;
    }

    @Override
    public Story save(Story story) {
        stories.add(story);
        return story;
    }
}
