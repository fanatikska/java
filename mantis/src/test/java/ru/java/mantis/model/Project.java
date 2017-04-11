package ru.java.mantis.model;

/**
 * Created by studenov-dv on 10.04.2017.
 */
public class Project {

    private int id;
    private String name;
    private Project status;

    public Project getStatus() {
        return status;
    }

    public Project withStatus(Project status) {
        this.status = status;
        return this;
    }

    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }
}
