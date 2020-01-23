package com.cralos.myrealmapplication.realm2.interfaces;

public interface Realm2Presenter {

    /*setDataToInteractor*/
    void addProfessor(String name, String age);

    void getOnlyProfessors();

    void getProfessorById(String id);

    void updateProfesorById(String id, String newName);

    void deleteProfessorById(String id);

    void deleteAllProfessors();

    /*SetDataToView*/

    void setMessageToView(String message);

    void setProfessorsToView(String professors);

    void setProfessor(String professorString);
}
