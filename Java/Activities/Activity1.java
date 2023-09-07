package Activities;

public class Activity1 {

    public static void main(String[] args) {

        CarActivity1 carName = new CarActivity1();
        carName.color="Black";
        carName.make= 2014;
        carName.transmission="Manual";

        carName.displayCharacteristics();
        carName.accelarate();
        carName.brake();

    }
}
