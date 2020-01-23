package com.cralos.myrealmapplication.realm3.presenters;

import com.cralos.myrealmapplication.realm3.interactors.Realm3InteractorImpl;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3Interactor;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3Presenter;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3View;
import com.cralos.myrealmapplication.realm3.models.Person;

import java.util.List;

public class Realm3PresenterImpl implements Realm3Presenter {

    private Realm3View view;
    private Realm3Interactor interactor;

    public Realm3PresenterImpl(Realm3View view) {
        this.view = view;
        interactor = new Realm3InteractorImpl(this);
    }

    @Override
    public void addNewPerson(String name) {
        if (view != null) {
            interactor.addNewPerson(name);
        }
    }

    @Override
    public void getPersonById(String id) {
        if (view != null) {
            interactor.getPersonById(id);
        }
    }

    @Override
    public void getAllPersons() {
        if (view != null) {
            interactor.getAllPersons();
        }
    }

    @Override
    public void addDogsById(String id) {
        if (view != null) {
            interactor.addDogsById(id);
        }
    }

    @Override
    public void deleteDogByUserId(String id) {
        if (view != null) {
            interactor.deleteDogByUserId(id);
        }
    }

    @Override
    public void setMessageToView(String message) {
        if (view != null) {
            view.showMessage(message);
        }
    }

    @Override
    public void setPersonToView(Person person) {
        if (view != null) {
            view.showPerson(person);
        }
    }

    @Override
    public void setAllPersonsToView(List<Person> persons) {
        if (view != null) {
            view.showAllPersons(persons);
        }
    }
}
