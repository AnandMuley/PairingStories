package com.abm.pairingstories.domain;

import com.abm.pairingstories.exceptions.NoPendingIterationException;

import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Story {

    private String name;
    private String description;
    private ExperienceRange experienceRange;
    private boolean completed;

    private Set<Iteration> iterations;

    private Story(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.experienceRange = builder.experienceRange;
        this.iterations = builder.iterations;
    }

    public Iteration getCurrentIteration() throws NoPendingIterationException {
        return iterations.stream().filter($ -> $.isNotCompleted()).findFirst().orElseThrow(NoPendingIterationException::new);
    }

    public void completedCurrentIteration() throws NoPendingIterationException {
        getCurrentIteration().setCompleted(true);
    }

    public void resetAllIterationsState() {
        iterations.forEach(iteration -> iteration.setCompleted(false));
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    public Set<Iteration> getIterations() {
        Count notCompletedCount = new Count();
        Predicate<Iteration> tillCurrent = $ -> notCompletedCount.isLessThan(2);
        return iterations.stream().peek($ -> {
            if ($.isNotCompleted()) {
                notCompletedCount.increment();
            }
        }).filter(tillCurrent).collect(Collectors.toCollection(TreeSet::new));
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
        private SortedSet<Iteration> iterations;
        private ExperienceRange experienceRange;

        public Builder(String name, String description, ExperienceRange experienceRange, SortedSet<Iteration> iterations) {
            this.name = name;
            this.description = description;
            this.iterations = iterations;
            this.experienceRange = experienceRange;
        }

        public Builder withIterations(Iteration iteration) {
            this.iterations.add(iteration);
            return this;
        }

        public Story build() {
            Iteration.Builder.resetSerialNo();
            return new Story(this);
        }
    }

}
