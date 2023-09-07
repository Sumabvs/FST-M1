package Activities;

import java.time.LocalDateTime;
import java.util.*;



class Plane{
    private ArrayList<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;



    public Plane(int mp){
        this.maxPassengers=mp;
        this.passengers=new ArrayList<String>();

    }

    void onboard(String passname){
        this.passengers.add(passname);

    }
    Date takeOff()
    {
        this.lastTimeTookOf=new Date();
        return this.lastTimeTookOf;
    }
    void land()
    {
        this.lastTimeLanded=takeOff();
        this.passengers.clear();
    }
    Date getLastTimeLanded(){
        return this.lastTimeLanded;
    }
    List<String> getPassesngers(){
        return this.passengers;
    }
}
public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane=new Plane(10);
        plane.onboard("Suma");
        plane.onboard("Shankar");
        plane.onboard("Ganesh");

        System.out.println("Plane takeoof time is: " + plane.takeOff());
        System.out.println("List of passenger in the plane:" + plane.getPassesngers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Last landed time of a plane is :"+plane.getLastTimeLanded());
    }
}
