package com.abm.pairingstories.domain;

import java.util.Objects;

public class Iteration {

    private int serialNo;
    private String content;
    private boolean completed;

    private Iteration(Builder builder) {
        this.serialNo = builder.serialNo;
        this.content = builder.content;
        this.completed = builder.completed;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isNotCompleted() {
        return !completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iteration iteration = (Iteration) o;
        return serialNo == iteration.serialNo &&
                Objects.equals(content, iteration.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNo, content);
    }

    @Override
    public String toString() {
        return "Iteration{" +
                "serialNo=" + serialNo +
                ", content='" + content + '\'' +
                ", completed=" + completed +
                '}';
    }

    public static class Builder {

        private int serialNo;
        private String content;
        private boolean completed;

        public Builder(int serialNo, String content) {
            this.serialNo = serialNo;
            this.content = content;
        }

        public Builder isCompleted(boolean status) {
            completed = status;
            return this;
        }

        public Iteration build() {
            return new Iteration(this);
        }

    }

}
