package com.abm.pairingstories.domain

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

class StorySpec extends Specification {

    @Subject
    @Shared
    Story story

    def setupSpec() {
        story = new Story()
    }

}
