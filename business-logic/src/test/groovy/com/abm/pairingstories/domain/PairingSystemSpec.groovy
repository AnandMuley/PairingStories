package com.abm.pairingstories.domain

import com.abm.pairingstories.exceptions.InvalidReviewerException
import com.abm.pairingstories.view.StoryView
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static com.abm.pairingstories.domain.ExperienceRange.between

class PairingSystemSpec extends Specification {

    @Subject
    PairingSystem pairingSystem

    void setup() {
        pairingSystem = new PairingSystem()
    }

    def "system should have stories"() {
        expect: "the count of stories should be 2"
        pairingSystem.storiesCount == 3
    }

    def "system should provide an option to add a story"() {
        given:
        Iteration firstIteration = new Iteration.Builder("First Iteration").build()
        Story cardGame = new Story.Builder("Card Game", "A game of cards", between(5, 10), [firstIteration] as TreeSet).build()

        when:
        pairingSystem.addStory(cardGame)

        then:
        pairingSystem.storiesCount == 4

        and: "story should be added to repository"
        pairingSystem.stories.contains(cardGame) == true
    }

    @Unroll
    def "should return story '#storyName' based on experience #yearsOfExperience years"() {
        when:
        StoryView actual = pairingSystem.getStory(yearsOfExperience)

        then:
        actual.name == storyName

        where:
        yearsOfExperience || storyName
        1                 || "SyntaxHighlighter"
        2                 || "SyntaxHighlighter"
        3                 || "SyntaxHighlighter"
        4                 || "CarRental"
        5                 || "CarRental"
    }

    def "reviewed - should make the current iteration as completed and load next"() {
        given:
        String reviewerName = "patrikrocks"
        pairingSystem.getStory(2)

        when:
        StoryView updatedWithNextIteration = pairingSystem.reviewed(reviewerName)

        then:
        updatedWithNextIteration.getIterations().size() == 2
        updatedWithNextIteration.iterations.findAll { it.completed == true }.size() == 1
        updatedWithNextIteration.iterations.findAll { it.completed == false }.size() == 1
        updatedWithNextIteration.completed == false

        when:
        updatedWithNextIteration = pairingSystem.reviewed(reviewerName)

        then:
        updatedWithNextIteration.getIterations().size() == 2
        updatedWithNextIteration.iterations.findAll { it.completed == true }.size() == 2
        updatedWithNextIteration.iterations.findAll { it.completed == false }.size() == 0
        updatedWithNextIteration.completed == true

    }

    def "reviewed - should return an error if any invalid reviewerName is given"() {
        given:
        String reviewerName = "patrik"
        pairingSystem.getStory(2)

        when:
        StoryView updatedWithNextIteration = pairingSystem.reviewed(reviewerName)

        then:
        updatedWithNextIteration.completed == false
        updatedWithNextIteration.errorMessage == InvalidReviewerException.defaultMessage

    }


}
