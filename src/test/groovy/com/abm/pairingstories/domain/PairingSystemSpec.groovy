package com.abm.pairingstories.domain

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class PairingSystemSpec extends Specification {

    @Subject
    PairingSystem pairingSystem

    void setup() {
        pairingSystem = new PairingSystem()
    }

    def "system should have stories"() {
        expect: "the count of stories should be 2"
        pairingSystem.storiesCount == 2
    }

    def "system should provide an option to add a story"() {
        given:
        Story cardGame = new Story("Card Game", ExperienceRange.between(5, 10))

        when:
        pairingSystem.addStory(cardGame)

        then:
        pairingSystem.storiesCount == 3
    }

    @Unroll
    def "should return story '#storyName' based on experience #yearsOfExperience years"() {
        when:
        Story actual = pairingSystem.getStory(yearsOfExperience)

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

}
