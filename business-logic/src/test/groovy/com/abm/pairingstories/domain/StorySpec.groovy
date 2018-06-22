package com.abm.pairingstories.domain

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static com.abm.pairingstories.domain.ExperienceRange.between

class StorySpec extends Specification {

    @Subject
    @Shared
    Story story

    @Shared
    Iteration firstIteration

    def setupSpec() {
        firstIteration = new Iteration.Builder(1, "Car Rental").build()
        story = new Story.Builder("Car Rental", "An application for renting cars",
                between(3, 5), firstIteration).build()
    }

    def "getCurrentIteration - should return current iteration"() {
        given:
        Iteration secondIteration = new Iteration.Builder(2, "Second Iteration").build()
        story.addIteration(secondIteration)

        when:
        Iteration actual = story.getCurrentIteration()

        then:
        actual.serialNo == 1
        actual.completed == false
        actual.content == "Car Rental"
        story.currentIteration == firstIteration
    }

    def "completedCurrentIteration - should update the state of current state and load next"() {
        when:
        story.completedCurrentIteration()

        then:
        story.getCurrentIteration().serialNo == 2
    }

    def "check for the getters"() {
        expect:
        story.getName() == "Car Rental"

        and:
        story.getDescription() == "An application for renting cars"
    }

    def "addIteration - should add an iteration to the story"() {
        given:
        Iteration iteration = new Iteration.Builder(1, "Some content").build()

        when:
        boolean actual = story.addIteration(iteration)

        then: "firstIteration should be added"
        actual == true
    }

    @Unroll
    def "suitableForExperience - should check if the story is suitable for experience of #yearsOfExperience of yrs"() {
        expect:
        story.suitableForExperience(yearsOfExperience) == expectedValue

        where:
        yearsOfExperience || expectedValue
        1                 || false
        3                 || false
        4                 || true
        5                 || true
        6                 || false

    }

    def "two stories are equal if they have same name"() {
        given:
        Story firstStory = new Story.Builder("Car Rental", "Renting a car app", between(1, 2), firstIteration).build()
        Story secondStory = new Story.Builder("Car Rental", "Rent a car app", between(2, 4), firstIteration).build()

        when: "stories are equal"
        firstStory == secondStory

        then: "hashcodes should be same"
        firstStory.hashCode() == secondStory.hashCode()
    }

    def "check for toString"() {
        expect:
        story.toString() == "Story{name='Car Rental', experienceRange=ExperienceRange{lowerBound=3, upperBound=5}}"
    }

}
