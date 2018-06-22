package com.abm.pairingstories.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Iteration;
import com.abm.pairingstories.domain.Story;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.abm.pairingstories.domain.ExperienceRange.between;

public class StoryRepository implements Repository<Story> {

    private AdvancedSet<Story> stories;
    private HtmlTemplateRepository htmlTemplateRepository;

    public StoryRepository() {
        stories = new AdvancedSet<>();
        htmlTemplateRepository = new HtmlTemplateRepository();
//        createData();
        stories = htmlTemplateRepository.loadData();
    }

    private void createData() {
        Iteration syntaxHighlighterFirstIteration = new Iteration.Builder(htmlTemplateRepository.load("syntaxhighlighter/IterationOne.html")).build();
        Iteration syntaxHighlighterSecondIteration = new Iteration.Builder(htmlTemplateRepository.load("syntaxhighlighter/IterationTwo.html")).build();
        SortedSet<Iteration> syntaxHighlighterIterations = new TreeSet<>();
        syntaxHighlighterIterations.add(syntaxHighlighterFirstIteration);
        syntaxHighlighterIterations.add(syntaxHighlighterSecondIteration);
        Story syntaxHighlighter = new Story.Builder("Syntax Highlighter",
                htmlTemplateRepository.load("SyntaxHighlighter_0_3.html"), between(0, 3),
                syntaxHighlighterIterations).build();

        Iteration carRentalFirstIteration = new Iteration.Builder(htmlTemplateRepository.load("carrental/IterationOne.html")).build();
        Iteration carRentalSecondIteration = new Iteration.Builder(htmlTemplateRepository.load("carrental/IterationTwo.html")).build();
        SortedSet<Iteration> carRentalIterations = new TreeSet<>();
        carRentalIterations.add(carRentalFirstIteration);
        carRentalIterations.add(carRentalSecondIteration);
        Story carRental = new Story.Builder("Car Rental",
                htmlTemplateRepository.load("CarRental_3_5.html"), between(3, 5),
                carRentalIterations).build();

        Iteration cardGameFirstIteration = new Iteration.Builder(htmlTemplateRepository.load("cardgame/IterationOne.html")).build();
        SortedSet<Iteration> cardGameIterations = new TreeSet<>();
        cardGameIterations.add(cardGameFirstIteration);
        Story cardGame = new Story.Builder("Card Game",
                htmlTemplateRepository.load("CardGame_5_10.html"), between(5, 10),
                cardGameIterations).build();

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
