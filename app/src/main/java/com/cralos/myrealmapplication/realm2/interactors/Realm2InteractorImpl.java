package com.cralos.myrealmapplication.realm2.interactors;

import android.app.Activity;

import com.cralos.myrealmapplication.realm2.interfaces.Realm2Interactor;
import com.cralos.myrealmapplication.realm2.interfaces.Realm2Presenter;
import com.cralos.myrealmapplication.realm2.models.Profesor;
import com.cralos.myrealmapplication.realm2.realmServices.ServicesProfesor;
import com.cralos.myrealmapplication.realm2.realmServices.ServicesProfesorRealmimpl;
import com.cralos.myrealmapplication.realm2.utils.Realm2Utils;

import java.util.List;

public class Realm2InteractorImpl implements Realm2Interactor {

    private Realm2Presenter presenter;
    private ServicesProfesor servicesProfesor;

    public Realm2InteractorImpl(Realm2Presenter presenter, Activity activity) {
        this.presenter = presenter;
        this.servicesProfesor = new ServicesProfesorRealmimpl(this, activity);
    }

    @Override
    public void addProfessorInRealm(String name, String age) {
        if (name == null || name.length() == 0 || age == null || age.length() == 0) {
            presenter.setMessageToView("Ingresar nombre y edad");
        } else {
            servicesProfesor.addProfessorInRealm(name, Integer.parseInt(age));
        }
    }

    @Override
    public void getOnlyProfessors() {
        servicesProfesor.getOnlyProfessors();
    }

    @Override
    public void getProfessorById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessageToView("Ingresa id del profesor");
        } else {
            servicesProfesor.getProfessorById(Integer.parseInt(id));
        }
    }

    @Override
    public void updateProfesorById(String id, String newName) {
        if (id == null || id.length() == 0 || newName == null || newName.length() == 0) {
            presenter.setMessageToView("Ingresa id y nuevo nombre");
        } else {
            servicesProfesor.updateProfesorById(Integer.parseInt(id), newName);
        }
    }

    @Override
    public void deleteProfessorById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessageToView("Ingresa id Professor");
        } else {
            servicesProfesor.deleteProfessorById(Integer.parseInt(id));
        }
    }

    @Override
    public void deleteAllProfessors() {
        servicesProfesor.deleteAllProfessors();
    }

    /**
     * METODOS DE RESPUESTA DE REALM
     */
    @Override
    public void successOrFailtureAddProfesor(String message) {
        presenter.setMessageToView(message);
    }

    @Override
    public void successOrFailtureProfessors(List<Profesor> profesors) {
        if (profesors == null || profesors.size() == 0) {
            presenter.setMessageToView("No se encontraron profesores");
        } else {
            presenter.setProfessorsToView(Realm2Utils.getProfessorsString(profesors));
        }
    }

    @Override
    public void setProfessor(Profesor professor) {
        if (professor == null) {
            presenter.setMessageToView("No existe usuario con ese ID");
            presenter.setProfessor("No existe profesor con ese ID");
        } else {
            presenter.setProfessor("id: " + professor.getId() + ", nombre: " + professor.getName());
        }
    }

    @Override
    public void successOrFailtureProfesorUpdate(String message) {
        presenter.setMessageToView(message);
    }

    @Override
    public void successOrFailtureDeleteProfessor(String message) {
        presenter.setMessageToView(message);
    }

}
