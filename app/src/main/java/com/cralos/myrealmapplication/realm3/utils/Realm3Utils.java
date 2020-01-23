package com.cralos.myrealmapplication.realm3.utils;

import com.cralos.myrealmapplication.realm3.models.Dog;

import java.util.ArrayList;
import java.util.List;

public class Realm3Utils {
    public static List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Nombre 1", "Negro 0"));
        dogs.add(new Dog("Nombre 2", "Negro 1"));
        dogs.add(new Dog("Nombre 3", "Negro 2"));
        dogs.add(new Dog("Nombre 4", "Negro 3"));
        dogs.add(new Dog("Nombre 5", "Negro 4"));
        return dogs;
    }
}
