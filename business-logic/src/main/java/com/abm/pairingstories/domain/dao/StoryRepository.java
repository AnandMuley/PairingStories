package com.abm.pairingstories.domain.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Story;

import static com.abm.pairingstories.domain.ExperienceRange.between;

public class StoryRepository implements Repository<Story> {

    private AdvancedSet<Story> stories;
    private HtmlTemplateRepository htmlTemplateRepository;

    public StoryRepository() {
        stories = new AdvancedSet<>();
        htmlTemplateRepository = new HtmlTemplateRepository();
        Story syntaxHighlighter = new Story("Syntax Highlighter", htmlTemplateRepository.load("SyntaxHighlighter.html"), between(0, 3));
        Story carRental = new Story("Car Rental", "The game is about distributing the cards first then <b>deciding</b> winner", between(3, 5));
        stories.add(syntaxHighlighter);
        stories.add(carRental);
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
