package com.abm.lambdacollections.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class AdvancedSet<E> extends HashSet<E> {

    public Optional<E> find(Predicate<E> filter) {
//        Objects.requireNonNull(filter);
        E foundElement = null;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            E currentEle = each.next();
            if (filter.test(currentEle)) {
                foundElement = currentEle;
                break;
            }
        }
        return Optional.ofNullable(foundElement);
    }

}
