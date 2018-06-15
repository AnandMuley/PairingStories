package com.abm.pairingstories.domain;

public class Story {

    private String name;
    private ExperienceRange experienceRange;

    public Story(String name, ExperienceRange experienceRange) {
        this.name = name;
        this.experienceRange = experienceRange;
    }

    public String getName() {
        return name;
    }

    public boolean suitableForExperience(int yearsOfExperience) {
        return experienceRange.contains(yearsOfExperience);
    }
}
