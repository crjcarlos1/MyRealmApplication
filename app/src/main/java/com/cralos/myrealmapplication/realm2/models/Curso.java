package com.cralos.myrealmapplication.realm2.models;

import io.realm.RealmObject;

public class Curso extends RealmObject {

    private String name;
    private String duration;

    public Curso() {
    }

    public Curso(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
