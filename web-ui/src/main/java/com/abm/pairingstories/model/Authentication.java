package com.abm.pairingstories.model;

import java.util.Arrays;

public class Authentication {

    public Authentication(String emailId, YearsOfExperience experience) {
        this.emailId = emailId;
        this.experience = experience;
    }

    private String emailId;
    private YearsOfExperience experience;

    public Authentication() {
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public YearsOfExperience getExperience() {
        return experience;
    }

    public void setExperience(int yearsOfExperience) {
        this.experience = YearsOfExperience.getFrom(yearsOfExperience);
    }

    public enum YearsOfExperience {
        THREE(3), FIVE(5), TEN(10);

        int value;

        YearsOfExperience(int experience) {
            value = experience;
        }

        static YearsOfExperience getFrom(int yearOfExperience) {
            return Arrays.stream(YearsOfExperience.values()).filter(it -> it.value == yearOfExperience).findAny().orElse(TEN);
        }

        public int getValue() {
            return value;
        }

    }

    @Override
    public String toString() {
        return "Authentication{" +
                "emailId='" + emailId + '\'' +
                ", experience=" + experience +
                '}';
    }
}
