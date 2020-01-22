package com.cralos.myrealmapplication.realm1.utils;

public class Realm1Validations {
    public static String validateData(String name, String email) {
        String validation = "SUCCESS";
        if (name == null || name.length() == 0) {
            validation = "Ingresa nombre";
        }
        if (email == null || email.length() == 0) {
            validation = "Ingresa correo electrónico";
        }
        return validation;
    }
}
