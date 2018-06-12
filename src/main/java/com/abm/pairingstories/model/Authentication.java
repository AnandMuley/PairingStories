package com.abm.pairingstories.model;

public class Authentication {

    public enum YearsOfExperience {
        THREE(3), FIVE(5), TEN(10);

        int value;

        YearsOfExperience(int experience){
            value = experience;
        }

        YearsOfExperience getFrom(int yearOfExperience){
            return null;
        }

        public int getValue() {
            return value;
        }

    }

    private String emailId;
    private String password;
    private YearsOfExperience experience;

    public Authentication(String emailId, String password, YearsOfExperience experience) {
        this.emailId = emailId;
        this.password = password;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", experience=" + experience +
                '}';
    }
}
