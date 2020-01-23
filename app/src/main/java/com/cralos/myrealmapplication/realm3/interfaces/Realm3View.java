package com.cralos.myrealmapplication.realm3.interfaces;

import com.cralos.myrealmapplication.realm3.models.Person;

import java.util.List;

public interface Realm3View {
    void showMessage(String message);

    void showPerson(Person person);

    void showAllPersons(List<Person> personList);
}
