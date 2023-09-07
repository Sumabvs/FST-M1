package Activities;


interface BicycleParts{
    public int gears=0;
    public int speed=0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);


}

class Bicycle implements BicycleParts, BicycleOperations {
    public  int gears;
    public int speed;

    public Bicycle(int gears, int speed){
        this.gears=gears;
        this.speed=speed;
    }
    public void applyBrake(int decrement){
        speed=decrement;
        System.out.println("Current speed after applyBrake:" + speed);
    }

    @Override
    public void speedUp(int increment) {
        speed+=increment;
        System.out.println("Current spped after SpeedUP:" +speed);
    }
    public String bicycleDesc(){
      return("No of gears " + gears + "and current speed is "+speed);
    }
}
class MountainBike extends Bicycle{
    int seatHeight;

    public MountainBike(int gears, int speed, int startHeight ){
        super(gears, speed);
        seatHeight=startHeight;

    }
    public void setHeight(int newvalue){
        seatHeight=newvalue;

    }
    public String bicycleDesc() {
        super.bicycleDesc();
        return ("\nSeat height is " + seatHeight);
    }
}
public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(4, 0, 30);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(10);
        mb.applyBrake(4);
    }
}
