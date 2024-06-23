package org.prog;

public class Car implements ITransport {

    private  String color;
    public int milage = 0;
String strMilage =Integer.toString(milage);
    public void goTo() {
        milage += 10;

        goTo("somewhere");
    }

    public void goTo(String destination) {
        goTo("current city", destination);
    }

    public void goTo(String from, String destination) {
        goTo(from, destination, "nowhere");
    }

    public void goTo(String from, String destination, String passingThrough) {
        System.out.println(color+" "+"Car is going from " + from + " to "
                + destination + " stopping at " + passingThrough);
    }

    public void turn(String direction) {
        System.out.println(color + " car turns " + direction);
    }

    public void stopAt(String stop) {
        System.out.println(color + "car stop" + stop);
    }

    public void setColor(String newColor) {
        if (newColor != null) {
            color = newColor;
        }
    }

    public String getColor() {
        return color;
    }
@Override
    public boolean  equals(Object o){
        if(o instanceof Car){
      Car obj = (Car) o;
            return this.strMilage .equals(obj.strMilage) && this.color.equals(obj.color);

        }
        return false;
}
@Override
    public int hashCode(){
        return (strMilage + color).hashCode();
}
}
