package com.cralos.myrealmapplication.realm1.presenters;

import com.cralos.myrealmapplication.realm1.interactors.Realm1InteractorImpl;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1Interactor;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1Presenter;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1View;

public class Realm1PresenterImpl implements Realm1Presenter {

    private Realm1View view;
    private Realm1Interactor interactor;

    public Realm1PresenterImpl(Realm1View view) {
        this.view = view;
        interactor = new Realm1InteractorImpl(this);
    }

    @Override
    public void saveUser(String name, String email) {
        if (view != null) {
            interactor.saveUser(name, email);
        }
    }

    @Override
    public void getUsers() {
        if (view != null) {
            interactor.getUsers();
        }
    }

    @Override
    public void deleteUserById(String id) {
        if (view != null) {
            interactor.deleteUserById(id);
        }
    }

    @Override
    public void updateUserById(String id) {
        if (view != null) {
            interactor.updateUserById(id);
        }
    }

    @Override
    public void setMessage(String message) {
        if (view != null) {
            view.showMessage(message);
        }
    }

    @Override
    public void setUsers(String users) {
        if (view != null) {
            view.showUsers(users);
        }
    }

}
