package com.cralos.myrealmapplication.realm3.interactors;

import com.cralos.myrealmapplication.realm3.interfaces.Realm3Interactor;
import com.cralos.myrealmapplication.realm3.interfaces.Realm3Presenter;
import com.cralos.myrealmapplication.realm3.models.Dog;
import com.cralos.myrealmapplication.realm3.models.Person;
import com.cralos.myrealmapplication.realm3.utils.Realm3Utils;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class Realm3InteractorImpl implements Realm3Interactor {

    private Realm3Presenter presenter;
    private Realm realm;

    public Realm3InteractorImpl(Realm3Presenter presenter) {
        this.presenter = presenter;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void addNewPerson(String name) {
        if (name == null || name.length() == 0) {
            presenter.setMessageToView("ingresa nombre");
            return;
        }
        realm.beginTransaction();
        Person person = realm.createObject(Person.class, getId()); // Create a new object
        person.setName(name);
        realm.commitTransaction();
        presenter.setMessageToView("se agrego persona ok");
    }

    @Override
    public void getPersonById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessageToView("Ingresa id");
            return;
        }
        Person person = realm.where(Person.class).equalTo("id", Integer.parseInt(id)).findFirst();
        if (person == null) {
            presenter.setMessageToView("No se encontro id");
        } else {
            presenter.setPersonToView(realm.copyFromRealm(person));
        }
    }

    @Override
    public void getAllPersons() {
        RealmResults<Person> personRealmResults = realm.where(Person.class).findAll();
        if (personRealmResults == null || personRealmResults.size() == 0) {
            presenter.setMessageToView("No hay personas en db");
        } else {
            presenter.setAllPersonsToView(realm.copyFromRealm(personRealmResults));
        }
    }

    @Override
    public void addDogsById(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessageToView("Ingresa id de la persona");
            return;
        }
        realm.beginTransaction();
        Person realmPerson = realm.where(Person.class).equalTo("id", Integer.parseInt(id)).findFirst();
        if (realmPerson != null) {
            List<Dog> dogs = Realm3Utils.getDogs();         /*creamos perros dummy*/
            realmPerson.getDogs().addAll(dogs);             /*agregamos los perros creados a la lista de perros del usuario*/
            realm.insertOrUpdate(realmPerson);              /*actualizamos*/
            presenter.setMessageToView("se agregaron mascotas");
        } else {
            presenter.setMessageToView("No se encontro persna con ese id");
        }
        realm.commitTransaction();
    }

    @Override
    public void deleteDogByUserId(String id) {
        if (id == null || id.length() == 0) {
            presenter.setMessageToView("Ingresa id");
            return;
        }
        realm.beginTransaction();
        Person realmPerson = realm.where(Person.class).equalTo("id", Integer.parseInt(id)).findFirst();

        if (realmPerson != null) {
            realmPerson.getDogs().deleteAllFromRealm();     /*traemos liste de perros del usuario y la eliminamos*/
            presenter.setMessageToView("Se eliminaron perros");
        } else {
            presenter.setMessageToView("No se encontró id");
        }

        realm.commitTransaction();
    }

    private static int getId() {
        Realm realm = Realm.getDefaultInstance();
        Number currentId = realm.where(Person.class).max("id");
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
