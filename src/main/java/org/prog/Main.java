package org.prog;

public class Main {

    /**
     * car1 == car2
     * #############################################
     * #############################################
     * #############################################
     * ############[Car : car1 | color:Red]#########
     * #############################################
     * #############################################
     * #############################################
     * #############################################
     * #############################################
     * ###[Car : car2 | color:Red]##################
     * ############################10###############
     *
     * @param args
     */


    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Boat Choven = new Boat();
        Truck truck1 = new Truck();
        BigTruck bigTruck = new BigTruck();
        BiggestTruck biggestTruck = new BiggestTruck();

        car1.setColor("Red");
        car2.setColor("Red");
        car3.setColor("Black");
        truck1.setColor("white");
        bigTruck.setColor("black");
        biggestTruck.setColor("yellow");

        Choven.goTo();
        Choven.stopAt("Beach");

        car1.goTo();
        car1.goTo("Kyiv");
        car1.stopAt("Gas Station");
        car1.goTo("Odessa", "Lviv");
        car1.stopAt("McDonald`s");
        car1.goTo("Kyiv","Sumy","Kharkiv");

        car2.goTo();
        car2.goTo("Kyiv");
        car2.stopAt("Gas Station");
        car2.goTo("Chernigiv","Odessa");
        car2.stopAt("McDonald`s");
        car2.goTo("Kyiv","Odessa","Dnipro");

        car3.goTo();
        car2.stopAt("Gas Station");


        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        System.out.println(car1.equals(car2) );
        System.out.println(car1.equals(car3) );


        Chair chairOne = new Chair();
        Chair chairTwo = new Chair();
        chairOne.color = "white";
        chairTwo.color = "white";
        chairOne.wood = "oak";
        chairTwo.wood = "oak";
        isChairWhite(chairOne);
        System.out.println(chairOne);
        System.out.println(chairTwo);
        System.out.println(chairOne.equals(chairTwo));
        System.out.println(chairOne.hashCode());
        System.out.println(chairTwo.hashCode());

        String s1 = "s1";
        String s2 = "";
        String s3 = null;

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    public static void isChairWhite(Chair chair) {
        if ("white".equals(chair.color)) {
            System.out.println("this chair is white");
        } else {
            System.out.println("this chair is not white");
        }
    }

    public static void transport(ITransport iTransport) {
        iTransport.goTo();
        iTransport.turn("left");
        iTransport.turn("right");
    }
}
