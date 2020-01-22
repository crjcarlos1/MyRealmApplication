package com.cralos.myrealmapplication.realm1.realmServices;

import com.cralos.myrealmapplication.realm1.models.User;
import com.cralos.myrealmapplication.realm1.utils.Realm1Validations;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class Realm1Services {

    public static List<User> getUsers() {   /*Las queries se realizan utilizando "where" */
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> results = realm.where(User.class).findAll();
        return realm.copyFromRealm(results);
    }

    public static String deleteUserById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        User user = realm.where(User.class).equalTo("id", id).findFirst();

        if (user != null) {
            user.deleteFromRealm();
            realm.commitTransaction();
            realm.close();
            return "Se borró de forma correcta al usuario";
        } else {
            realm.commitTransaction();
            realm.close();
            return "No existe matrícula";
        }
    }

    public static String updateUserById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        User user = realm.where(User.class).equalTo("id", id).findFirst();
        if (user != null) {
            user.setName("NombreModificado");
            realm.insertOrUpdate(user);
            realm.commitTransaction();
            realm.close();
            return "Se actualizó correctamente";
        } else {
            realm.commitTransaction();
            realm.close();
            return "No se encontro usuario";
        }


    }

    public static String saveUser(String name, String email) {
        String validation = Realm1Validations.validateData(name, email);
        if (!validation.equals("SUCCESS")) {
            return validation;
        } else {
            Realm realm = Realm.getDefaultInstance();
            try {
                realm.beginTransaction();                               /*escucha por lo que se realizará en la db*/
                User user = realm.createObject(User.class, getId());
                user.setName(name);
                user.setEmail(email);
                realm.commitTransaction();
            } finally {
                realm.close();
            }
            return "Se guardo correctamente";
        }
    }

    private static int getId() {
        Realm realm = Realm.getDefaultInstance();
        Number currentId = realm.where(User.class).max("id");
        int id;
        if (currentId == null) {
            id = 0;
        } else {
            id = currentId.intValue() + 1;
        }
        realm.close();
        return id;
    }

}
