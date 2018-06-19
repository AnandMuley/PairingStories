package com.abm.pairingstories.domain;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Story {

    private String name;
    private String description;
    private Set<Iteration> iterations;
    private ExperienceRange experienceRange;

    private Story(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.experienceRange = builder.experienceRange;
        this.iterations = builder.iterations;
    }

    public Iteration getCurrentIteration() {
        Iterator<Iteration> iterator = iterations.iterator();
        Iteration iteration = null;
        if (iterator.hasNext()) {
            iteration = iterator.next();
        }
        return iteration;
    }

    public boolean addIteration(Iteration iteration) {
        return iterations.add(iteration);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean suitableForExperience(int yearsOfExperience) {
        return experienceRange.contains(yearsOfExperience);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(name, story.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Story{" +
                "name='" + name + '\'' +
                ", experienceRange=" + experienceRange +
                '}';
    }

    public static class Builder {
        private String name;
        private String description;
        private Set<Iteration> iterations;
        private ExperienceRange experienceRange;

        public Builder(String name, String description, ExperienceRange experienceRange, Iteration iteration) {
            this.name = name;
            this.description = description;
            iterations = new LinkedHashSet<>();
            iterations.add(iteration);
            this.experienceRange = experienceRange;
        }

        public Builder withIterations(Iteration iteration) {
            this.iterations.add(iteration);
            return this;
        }

        public Story build() {
            return new Story(this);
        }
    }

}
