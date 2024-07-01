package org.prog.collections;

import org.prog.Car;

import java.util.*;

public class MapsPractice {

    //TODO: paint all cars that dont have any color
    public static void main(String[] args) {
        Map<String, List<Car>> ownedCars = new HashMap<>();
        String owner1 = "John";
        String owner2 = "Jane";
        String owner3 = "Peter";
        String owner4 = "Semen";
        Car car = new Car();
        car.setColor("Red");

        ownedCars.put(owner1, new ArrayList<>());
        ownedCars.put(owner2, new ArrayList<>());
        ownedCars.put(owner3, new ArrayList<>());
        ownedCars.put(owner4, new ArrayList<>());
        ownedCars.get(owner1).add(car);
        ownedCars.get(owner1).add(new Car());
        ownedCars.get(owner2).add(car);
        ownedCars.get(owner2).add(new Car());
        ownedCars.get(owner3).add(car);
        ownedCars.get(owner3).add(new Car());
        ownedCars.get(owner4).add(car);
        ownedCars.get(owner4).add(new Car());
        //TODO: HW4 starts here
        ownedCars.get(owner1);
        for (int i = 1; i < owner1.length(); i++) {
            ownedCars.get(owner1).get(i).setColor("Black");
        }
        ownedCars.get(owner2);
        for (int i = 1; i < owner2.length(); i++) {
            ownedCars.get(owner2).get(i).setColor("White");
        }
        ownedCars.get(owner3);
        for (int i = 1; i < owner3.length(); i++) {
            ownedCars.get(owner3).get(i).setColor("Blue");

        }
    }
}