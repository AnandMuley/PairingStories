package com.abm.pairingstories.dao;

import com.abm.lambdacollections.core.AdvancedSet;
import com.abm.pairingstories.domain.Reviewer;

public class ReviewerRepository implements Repository<Reviewer> {

    @Override
    public AdvancedSet<Reviewer> getAll() {
        AdvancedSet<Reviewer> reviewers = new AdvancedSet<>();
        reviewers.add(new Reviewer("Andie", "andierocks"));
        reviewers.add(new Reviewer("Patrik", "patrikrocks"));
        return reviewers;
    }

    @Override
    public Reviewer save(Reviewer reviewer) {
        return null;
    }
}
