package com.abm.pairingstories.view

import com.abm.pairingstories.domain.Iteration
import com.abm.pairingstories.domain.Story
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

import static com.abm.pairingstories.domain.ExperienceRange.between

class StoryViewSpec extends Specification {

    @Subject
    @Shared
    Story story

    @Shared
    Iteration firstIteration

    @Shared
    Iteration secondIteration

    def setupSpec() {
        firstIteration = new Iteration.Builder("Rent a SUV for 10\$").build()
        secondIteration = new Iteration.Builder("Rent any CAR for free").build()
        story = new Story.Builder("Car Rental", "Renting your car for the day",
                between(3, 5), [firstIteration, secondIteration] as TreeSet).build()

    }

    def "constructor - should create a story view from the story"() {
        when:
        StoryView actual = StoryView.getInstance(story)

        then:
        actual.name == story.name
        actual.description == story.description

        def actualIterations = actual.iterations
        actualIterations.size() == 1
        IterationView actualIteration = actualIterations[0]
        actualIteration.serialNo == firstIteration.serialNo
        actualIteration.content == firstIteration.content
        actualIteration.completed == false
    }

    def "actual iterations should contain values of earlier completed iterations too"() {
        given:
        story.completedCurrentIteration()

        when:
        StoryView actual = StoryView.getInstance(story)

        then:
        actual.iterations.size() == 2
    }

}
