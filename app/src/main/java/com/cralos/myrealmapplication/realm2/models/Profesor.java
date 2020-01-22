package com.cralos.myrealmapplication.realm2.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Profesor extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private int edad;
    private RealmList<Curso> cursos;        /*relación 1 a muchos -> un maestro puede tener varios cursos*/

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(RealmList<Curso> cursos) {
        this.cursos = cursos;
    }
}
