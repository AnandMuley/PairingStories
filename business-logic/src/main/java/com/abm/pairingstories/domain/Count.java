package com.abm.pairingstories.domain;

public class Count {

    private int value;

    public void increment() {
        value++;
    }

    public boolean isLessThan(int value) {
        return this.value < value;
    }

    public int getValue() {
        return value;
    }
}
