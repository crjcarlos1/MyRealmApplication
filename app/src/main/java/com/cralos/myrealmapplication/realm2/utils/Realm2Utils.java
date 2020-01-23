package com.cralos.myrealmapplication.realm2.utils;

import com.cralos.myrealmapplication.realm2.models.Profesor;

import java.util.List;

public class Realm2Utils {

    public static String getProfessorsString(List<Profesor> profesors) {
        String professorsString = "";
        for (Profesor profesor : profesors) {
            professorsString += "id: " + profesor.getId() + ", nombre: " + profesor.getName() + ", edad: " + profesor.getEdad() + "\n\n";
        }
        return professorsString;
    }

}
