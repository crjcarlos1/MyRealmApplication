package com.cralos.myrealmapplication.realm3.interfaces;

public interface Realm3Interactor {
    void addNewPerson(String name);
    void getPersonById(String id);
    void getAllPersons();
    void addDogsById(String id);
    void deleteDogByUserId(String id);
}
