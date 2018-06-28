package com.abm.pairingstories.model;

import com.abm.pairingstories.domain.PairingSystem;

import java.util.Arrays;

public class Authentication {

    public Authentication(String emailId, YearsOfExperience experience) {
        this.emailId = emailId;
        this.experience = experience;
    }

    private String emailId;
    private YearsOfExperience experience;
    private PairingSystem pairingSystem;

    public Authentication() {
    }

    public PairingSystem getPairingSystem() {
        return pairingSystem;
    }

    public void setPairingSystem(PairingSystem pairingSystem) {
        this.pairingSystem = pairingSystem;
    }

    public void removePairingSystem() {
        this.pairingSystem = null;
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
