package com.abm.pairingstories.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Iteration;
import com.abm.pairingstories.domain.Story;

import java.util.Arrays;

import static com.abm.pairingstories.domain.ExperienceRange.between;

public class StoryRepository implements Repository<Story> {

    private AdvancedSet<Story> stories;
    private HtmlTemplateRepository htmlTemplateRepository;

    public StoryRepository() {
        stories = new AdvancedSet<>();
        htmlTemplateRepository = new HtmlTemplateRepository();
        createData();
    }

    private void createData() {

        Iteration syntaxHighlighterIteration = new Iteration.Builder(1, htmlTemplateRepository.load("syntaxhighlighter/IterationOne.html")).build();
        Story syntaxHighlighter = new Story.Builder("Syntax Highlighter", htmlTemplateRepository.load("SyntaxHighlighter.html"), between(0, 3), syntaxHighlighterIteration).build();

        Iteration carRentalIteration = new Iteration.Builder(1, htmlTemplateRepository.load("carrental/IterationOne.html")).build();
        Story carRental = new Story.Builder("Car Rental", htmlTemplateRepository.load("CarRental.html"), between(3, 5), carRentalIteration).build();

        Iteration cardGameIteration = new Iteration.Builder(1, htmlTemplateRepository.load("cardgame/IterationOne.html")).build();
        Story cardGame = new Story.Builder("Card Game", htmlTemplateRepository.load("CardGame.html"), between(5, 10), cardGameIteration).build();

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
