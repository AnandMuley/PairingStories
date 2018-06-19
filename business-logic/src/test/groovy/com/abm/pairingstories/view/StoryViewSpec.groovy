package com.abm.pairingstories.view

import com.abm.pairingstories.domain.Iteration
import com.abm.pairingstories.domain.Story
import spock.lang.Specification

import static com.abm.pairingstories.domain.ExperienceRange.between

class StoryViewSpec extends Specification {

    def "constructor - should create a story view from the story"() {
        given:
        def STORY_NAME = "Car Rental"
        def STORY_DESCRIPTION = "Renting your car for the day"
        def ITERATION_DESC = "Rent a SUV for 10\$"
        def ITERATION_SR_NO = 1

        Iteration iteration = new Iteration.Builder(ITERATION_SR_NO, ITERATION_DESC).build()
        Story story = new Story.Builder(STORY_NAME, STORY_DESCRIPTION, between(3, 5), iteration).build()

        when:
        StoryView actual = StoryView.getInstance(story)

        then:
        actual.name == STORY_NAME
        actual.description == STORY_DESCRIPTION
        actual.getCurrentIteration() != null
        IterationView actualIteration = actual.getCurrentIteration()
        actualIteration.serialNo == ITERATION_SR_NO
        actualIteration.content == ITERATION_DESC
        actualIteration.completed == false

    }

}
