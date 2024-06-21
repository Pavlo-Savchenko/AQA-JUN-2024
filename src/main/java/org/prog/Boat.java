package org.prog;

public class Boat implements ITransport {
    public void goTo() {
        System.out.println("Boat sails somewhere");
    }

    public void turn(String direction) {
        System.out.println("Boat turns " + direction);
    }

    public void setSail() {
        System.out.println("Set sail!");
    }
}
