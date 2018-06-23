package com.abm.pairingstories.domain;

import com.abm.pairingstories.specifications.CodeMatcher;

import java.util.Objects;

public class Reviewer implements CodeMatcher<String> {

    private String name;
    private String code;

    public Reviewer(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean codesAreEqual(String that) {
        return this.code.equals(that);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviewer reviewer = (Reviewer) o;
        return Objects.equals(name, reviewer.name) &&
                Objects.equals(code, reviewer.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, code);
    }

    public class Builder {

        private String name;
        private String code;

        public Builder(String code) {
            this.code = code;
        }
    }
}
