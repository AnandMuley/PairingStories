package com.abm.pairingstories.validators;

public interface Validator<T> {

    ConditionallyExecute isValid(T t);

}
