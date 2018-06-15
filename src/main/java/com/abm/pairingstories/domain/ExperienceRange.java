package com.abm.pairingstories.domain;

public class ExperienceRange {

    private int lowerBound;
    private int upperBound;

    private ExperienceRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static ExperienceRange between(int lowerBound, int upperBound) {
        return new ExperienceRange(lowerBound, upperBound);
    }

    public boolean contains(int yearsOfExperience) {
        return lowerBound < yearsOfExperience && yearsOfExperience <= upperBound;
    }
}
