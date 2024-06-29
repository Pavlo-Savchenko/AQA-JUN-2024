package org.prog.collections;

import org.prog.Car;

import java.util.ArrayList;
import java.util.List;
public class ListHomeWork {

    //TODO: HW3
    //TODO: - Write ArrayList which you will fill with 10 different cars
    //TODO: - Paint each 2nd car in black, others in white
    //TODO: - each car must go its index * 10 + 10 km [0*10 + 10 = 0; 1*10 + 10 = 20]
    //TODO: - print color and milage for each car after this "race"

    public static void main(String[] args) {
        int l=10;
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);

        for (int i = 1; i < cars.size(); i += 2) {
            cars.get(i).setColor("white");
        }
        for (int j = 0; j < cars.size(); j += 2) {
            cars.get(j).setColor("black");
        }
        for (int k = 0; k < cars.size(); k++) {
            cars.get(k).goTo();
            System.out.println(k*10+10+" км");
        }
        }

    }

