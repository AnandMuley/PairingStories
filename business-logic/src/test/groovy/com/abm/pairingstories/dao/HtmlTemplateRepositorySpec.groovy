package com.abm.pairingstories.dao

import com.abm.lambdacollections.core.AdvancedSet
import com.abm.pairingstories.domain.Story
import spock.lang.Specification
import spock.lang.Subject

class HtmlTemplateRepositorySpec extends Specification {

    @Subject
    HtmlTemplateRepository htmlTemplateRepository

    void setup() {
        htmlTemplateRepository = new HtmlTemplateRepository()
    }

    def "loadData - should load all stories from the resource location"() {
        when:
        AdvancedSet<Story> actualStories = htmlTemplateRepository.loadData()

        then:
        actualStories.size() == 3
    }
}
