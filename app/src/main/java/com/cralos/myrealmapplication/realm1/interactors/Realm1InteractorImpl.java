package com.cralos.myrealmapplication.realm1.interactors;

import com.cralos.myrealmapplication.realm1.interfaces.Realm1Interactor;
import com.cralos.myrealmapplication.realm1.interfaces.Realm1Presenter;
import com.cralos.myrealmapplication.realm1.models.User;
import com.cralos.myrealmapplication.realm1.realmServices.Realm1Services;

import java.util.List;

public class Realm1InteractorImpl implements Realm1Interactor {

    private Realm1Presenter presenter;

    public Realm1InteractorImpl(Realm1Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveUser(String name, String email) {
        presenter.setMessage(Realm1Services.saveUser(name, email));
    }

    @Override
    public void getUsers() {
        List<User> users = Realm1Services.getUsers();
        if (users == null || users.size() == 0) {
            presenter.setMessage("No hay usuarios en realm");
        } else {
            StringBuilder usersString = new StringBuilder();
            for (User user : users) {
                usersString.append(user.getId()).append(", ").append(user.getName()).append(", ").append(user.getEmail()).append("\n\n");
            }
            presenter.setUsers(usersString.toString());
        }
    }

    @Override
    public void deleteUserById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessage("Ingresa id de usuario");
        } else {
            int idInteger = Integer.parseInt(id);
            String validation = Realm1Services.deleteUserById(idInteger);
            presenter.setMessage(validation);
        }
    }

    @Override
    public void updateUserById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessage("Ingresa id de usuario");
        } else {
            int idInteger = Integer.parseInt(id);
            String validation = Realm1Services.updateUserById(idInteger);
            presenter.setMessage(validation);
        }

    }
}
