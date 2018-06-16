package com.abm.pairingstories.domain;

import java.util.Objects;

public class Story {

    private String name;
    private String description;
    private ExperienceRange experienceRange;

    public Story(String name, String description, ExperienceRange experienceRange) {
        this.name = name;
        this.description = description;
        this.experienceRange = experienceRange;
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
