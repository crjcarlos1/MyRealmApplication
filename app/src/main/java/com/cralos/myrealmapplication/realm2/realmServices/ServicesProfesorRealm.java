package com.cralos.myrealmapplication.realm2.realmServices;

import com.cralos.myrealmapplication.realm2.models.Profesor;

import io.realm.Realm;

public class ServicesProfesorRealm {

    private static int getId() {
        Realm realm = Realm.getDefaultInstance();
        Number currentId = realm.where(Profesor.class).max("id");
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
