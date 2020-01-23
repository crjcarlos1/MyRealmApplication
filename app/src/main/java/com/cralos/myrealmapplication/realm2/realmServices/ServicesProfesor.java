package com.cralos.myrealmapplication.realm2.realmServices;

public interface ServicesProfesor {
    void addProfessorInRealm(String name, int age);

    void getOnlyProfessors();

    void getProfessorById(int id);

    void updateProfesorById(int id, String newName);

    void deleteProfessorById(int id);

    void deleteAllProfessors();
}
