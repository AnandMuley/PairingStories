package com.abm.pairingstories.domain

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
        Iteration firstIteration = new Iteration.Builder(1, "First Iteration").build()
        Story cardGame = new Story.Builder("Card Game", "A game of cards", between(5, 10), firstIteration).build()

        when:
        pairingSystem.addStory(cardGame)

        then:
        pairingSystem.storiesCount == 3

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
        1                 || "Syntax Highlighter"
        2                 || "Syntax Highlighter"
        3                 || "Syntax Highlighter"
        4                 || "Car Rental"
        5                 || "Car Rental"
    }

    def "reviewed - should make the current iteration as completed and load next"() {
        given:
        pairingSystem.getStory(2)

        when:
        StoryView updatedWithNextIteration = pairingSystem.reviewed()

        then:
        updatedWithNextIteration.completed == true
    }

}
