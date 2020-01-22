package com.cralos.myrealmapplication.realm1.interfaces;

public interface Realm1Interactor {
    void saveUser(String name,String email);
    void getUsers();
    void deleteUserById(String id);
    void updateUserById(String id);
}
