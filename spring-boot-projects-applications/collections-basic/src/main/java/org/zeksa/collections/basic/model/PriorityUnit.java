package org.zeksa.collections.basic.model;

public class PriorityUnit implements Comparable {

    private String name;
    private int priority;

    public PriorityUnit(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PriorityUnit{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        PriorityUnit that = (PriorityUnit) o;
        if (this.priority >= that.getPriority() && this.priority%2==that.priority%2) {
            return 1;
        } else {
            return -1;
        }
    }
}
