package com.cralos.myrealmapplication.realm2.interfaces;

import com.cralos.myrealmapplication.realm2.models.Profesor;

import java.util.List;

public interface Realm2Interactor {
    void addProfessorInRealm(String name, String age);

    void getOnlyProfessors();

    void getProfessorById(String id);

    void updateProfesorById(String id, String newName);

    void deleteProfessorById(String id);

    void deleteAllProfessors();

    /*REALM METHODS RESPONSE*/
    void successOrFailtureAddProfesor(String message);

    void successOrFailtureProfessors(List<Profesor> profesors);

    void setProfessor(Profesor professor);

    void successOrFailtureProfesorUpdate(String message);

    void successOrFailtureDeleteProfessor(String message);

}
