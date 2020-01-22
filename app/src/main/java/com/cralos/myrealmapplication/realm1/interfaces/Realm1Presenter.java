package com.cralos.myrealmapplication.realm1.interfaces;

public interface Realm1Presenter {
    void saveUser(String name,String email);
    void getUsers();
    void deleteUserById(String id);
    void updateUserById(String id);

    void setMessage(String message);
    void setUsers(String users);
}
