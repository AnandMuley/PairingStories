package com.abm.pairingstories.validators;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConditionallyExecute {

    private boolean isTrue;
    private boolean isError;

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
                isError = true;
            }
        }
        return this;
    }

    public void otherwise(Supplier<Throwable> supplier) throws Throwable {
        if (!isTrue) {
            throw supplier.get();
        }
    }

    public ConditionallyExecute onErrorInThen(Consumer<Boolean> consumer) {
        if (isError) {
            consumer.accept(!isTrue);
        }
        return this;
    }

}
