package com.abm.pairingstories.validators;

import com.abm.pairingstories.dao.Repository;
import com.abm.pairingstories.domain.Reviewer;

import java.util.Set;

public class ReviewerValidator implements Validator<String> {

    private Set<Reviewer> reviewers;

    public ReviewerValidator(Repository<Reviewer> reviewerRepository) {
        reviewers = reviewerRepository.getAll();
    }

    @Override
    public ConditionallyExecute isValid(String reviewedBy) {
        return ConditionallyExecute.of(reviewers.stream().filter($ -> $.codesAreEqual(reviewedBy)).findAny().isPresent());
    }
}
