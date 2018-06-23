package com.abm.pairingstories.validators;

import java.util.function.Consumer;

public class ConditionallyExecute {

    private boolean isTrue;

    private ConditionallyExecute(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public static ConditionallyExecute of(boolean isTrue) {
        return new ConditionallyExecute(isTrue);
    }

    public ConditionallyExecute then(Executable executable) {
        if (isTrue) {
            try {
                executable.execute();
            } catch (Exception e) {
                isTrue = false;
            }
        }
        return this;
    }

    public void onErrorInThen(Consumer<Boolean> consumer) {
        if (!isTrue) {
            consumer.accept(!isTrue);
        }
    }

}
