package org.zeksa.collections.basic.model;

public class Customer1 {

    private String id;
    private String name;

    public Customer1(String id, String name){
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer1 customer1 = (Customer1) o;

        if (!id.equals(customer1.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
