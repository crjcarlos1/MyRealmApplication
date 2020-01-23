package com.cralos.myrealmapplication.realm3.interfaces;

import com.cralos.myrealmapplication.realm3.models.Person;

import java.util.List;

public interface Realm3Presenter {

    /*setDataToInteractor*/
    void addNewPerson(String name);

    void getPersonById(String id);

    void getAllPersons();

    void addDogsById(String id);

    void deleteDogByUserId(String id);

    /*setDataToView*/
    void setMessageToView(String message);

    void setPersonToView(Person person);

    void setAllPersonsToView(List<Person> persons);
}
