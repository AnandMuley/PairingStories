package com.abm.pairingstories.dao

import com.abm.pairingstories.domain.ExperienceRange
import spock.lang.Specification
import spock.lang.Subject

class StoryNameSpec extends Specification {

    @Subject
    StoryName storyName

    String filename = "SyntaxHighlighter_0_3.html"

    void setup() {
        storyName = new StoryName(filename)
    }

    def "getExperienceRange - should extract experience range from filename"() {
        when:
        ExperienceRange experienceRange = storyName.getExperienceRange()

        then:
        experienceRange.contains(0) == false
        experienceRange.contains(1) == true
        experienceRange.contains(3) == true
    }

    def "getValueFromFilename - should extract story name from filename"() {
        expect:
        storyName.getValueFromFilename() == "SyntaxHighlighter"
    }

    def "getIterationsFolderName - should get the iterations folder name"() {
        expect:
        storyName.getIterationsFolderName() == "syntaxhighlighter"
    }
}
