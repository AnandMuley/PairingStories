package com.abm.pairingstories.dao;

import com.abm.pairingstories.domain.ExperienceRange;

public class StoryName {

    private String filename;

    public StoryName(String filename) {
        this.filename = filename;
    }

    public ExperienceRange getExperienceRange() {
        String experienceRange = filename.substring(filename.indexOf("_"), filename.indexOf("."));
        String[] rangeValues = experienceRange.split("_");
        return ExperienceRange.between(Integer.parseInt(rangeValues[1]), Integer.parseInt(rangeValues[2]));
    }

    public String getValueFromFilename() {
        return filename.substring(0, filename.indexOf("_"));
    }

    public String getIterationsFolderName() {
        return getValueFromFilename().replaceAll(" ", "").toLowerCase();
    }

}
