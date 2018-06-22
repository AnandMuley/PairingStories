package com.abm.pairingstories.view;

import com.abm.pairingstories.domain.Iteration;

public class IterationView implements Comparable<IterationView> {

    private int serialNo;
    private String content;
    private boolean completed;

    public IterationView(Iteration iteration) {
        this.serialNo = iteration.getSerialNo();
        this.content = iteration.getContent();
        this.completed = iteration.isCompleted();
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

    @Override
    public int compareTo(IterationView o) {
        int result = 0;
        if (serialNo > o.serialNo) {
            result = 1;
        } else if (serialNo < o.serialNo) {
            result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "IterationView{" +
                "serialNo=" + serialNo +
                ", content='" + content + '\'' +
                ", completed=" + completed +
                '}';
    }
}
