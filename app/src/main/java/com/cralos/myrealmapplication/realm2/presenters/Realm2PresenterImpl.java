package com.cralos.myrealmapplication.realm2.presenters;

import android.app.Activity;

import com.cralos.myrealmapplication.realm2.interactors.Realm2InteractorImpl;
import com.cralos.myrealmapplication.realm2.interfaces.Realm2Interactor;
import com.cralos.myrealmapplication.realm2.interfaces.Realm2Presenter;
import com.cralos.myrealmapplication.realm2.interfaces.Realm2View;

public class Realm2PresenterImpl implements Realm2Presenter {

    private Realm2Interactor interactor;
    private Realm2View view;

    public Realm2PresenterImpl(Realm2View view, Activity activity) {
        this.view = view;
        interactor = new Realm2InteractorImpl(this, activity);
    }

    @Override
    public void addProfessor(String name, String age) {
        if (view != null) {
            interactor.addProfessorInRealm(name, age);
        }
    }

    @Override
    public void getOnlyProfessors() {
        if (view != null) {
            interactor.getOnlyProfessors();
        }
    }

    @Override
    public void getProfessorById(String id) {
        if (view != null) {
            interactor.getProfessorById(id);
        }
    }

    @Override
    public void updateProfesorById(String id, String newName) {
        if (view != null) {
            interactor.updateProfesorById(id, newName);
        }
    }

    @Override
    public void deleteProfessorById(String id) {
        if (view != null) {
            interactor.deleteProfessorById(id);
        }
    }

    @Override
    public void deleteAllProfessors() {
        if (view != null) {
            interactor.deleteAllProfessors();
        }
    }

    /*MÉTODOS QUE ENVIAN RESULTADOS AL VIEW*/
    @Override
    public void setMessageToView(String message) {
        if (view != null) {
            view.showMessage(message);
        }
    }

    @Override
    public void setProfessorsToView(String professors) {
        if (view != null) {
            view.showProfessorList(professors);
        }
    }

    @Override
    public void setProfessor(String professorString) {
        if (view != null) {
            view.showProfessor(professorString);
        }
    }
}
