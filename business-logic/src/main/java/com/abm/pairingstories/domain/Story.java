package com.abm.pairingstories.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Story {

    private String name;
    private String description;
    private Set<Iteration> iterations;
    private ExperienceRange experienceRange;

    public Story(String name, String description, ExperienceRange experienceRange) {
        this.name = name;
        this.description = description;
        this.experienceRange = experienceRange;
        iterations = new LinkedHashSet<>();
    }

    public Iteration getCurrentIteration() {
        return iterations.iterator().next();
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

}
