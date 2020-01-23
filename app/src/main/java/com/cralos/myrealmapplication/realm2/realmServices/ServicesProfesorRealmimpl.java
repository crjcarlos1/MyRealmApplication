package com.cralos.myrealmapplication.realm2.realmServices;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.cralos.myrealmapplication.realm2.interfaces.Realm2Interactor;
import com.cralos.myrealmapplication.realm2.models.Profesor;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Para este caso "ServicesProfessorRealmImpl" es el sujeto observablle
 */

public class ServicesProfesorRealmimpl implements ServicesProfesor {

    private Realm2Interactor interactor;
    private Activity activity;

    public ServicesProfesorRealmimpl(Realm2Interactor interactor, Activity activity) {
        this.interactor = interactor;
        this.activity = activity;
    }

    @Override
    public void addProfessorInRealm(final String name, final int age) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                Profesor realmProfesor = realm.createObject(Profesor.class, getId());
                realmProfesor.setName(name);
                realmProfesor.setEdad(age);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                interactor.successOrFailtureAddProfesor("Se agrego profesor de forma correcta");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                interactor.successOrFailtureAddProfesor(error.getMessage());
            }
        });
    }

    @Override
    public void getOnlyProfessors() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
        interactor.successOrFailtureProfessors(realm.copyFromRealm(profesors));     /*parseamos a un List de java*/
        realm.close();
    }

    @Override
    public void getProfessorById(int id) {
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();  // realm prof
        interactor.setProfessor(realm.copyFromRealm(profesor));
        realm.close();
    }

    @Override
    public void updateProfesorById(final int id, final String newName) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                final Profesor realmProfesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
                if (realmProfesor != null) {
                    realmProfesor.setName(newName);
                    realm.insertOrUpdate(realmProfesor);
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (realmProfesor != null) {
                            interactor.successOrFailtureProfesorUpdate("Se actualizó profesor de forma correcta");
                        } else {
                            interactor.successOrFailtureProfesorUpdate("No se encontró ID");
                        }
                    }
                });
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //interactor.successOrFailtureProfesorUpdate("Se actualizó profesor de forma correcta");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                interactor.successOrFailtureAddProfesor(error.getMessage());
            }
        });
    }

    @Override
    public void deleteProfessorById(final int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                final Profesor realmProfesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
                if (realmProfesor != null) {
                    realmProfesor.deleteFromRealm();
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (realmProfesor != null) {
                            interactor.successOrFailtureProfesorUpdate("Se eliminÓ profesor de forma correcta");
                        } else {
                            interactor.successOrFailtureProfesorUpdate("No se encontro ID");
                        }
                    }
                });
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //interactor.successOrFailtureProfesorUpdate("Se eliminÓ profesor de forma correcta");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                interactor.successOrFailtureAddProfesor(error.getMessage());
            }
        });
    }

    @Override
    public void deleteAllProfessors() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
                final boolean status = profesors.deleteAllFromRealm();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status) {
                            interactor.successOrFailtureProfesorUpdate("Se borraron todos los profesores");
                        } else {
                            interactor.successOrFailtureProfesorUpdate("Error no se pudo borrar profesores");
                        }
                    }
                });
            }
        });
    }

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
