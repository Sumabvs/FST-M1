package Activities;

import java.util.ArrayList;

public class Activity9 {

    public static void main(String args[]) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Banglore");
        myList.add("Mysore");
        myList.add("Chennai");
        myList.add("Hydrabad");
        myList.add("Delhi");

        for(String p:myList){
            System.out.println(p);
        }

        System.out.println("3rd value in the list is: " +myList.get(3));
        System.out.println("Checking if Banglore is available in the list: "+myList.contains("Banglore"));
        System.out.println("Number of elements in the list :" +myList.size());
        System.out.println("Removing the city name from the list is: " +myList.remove(2));
        System.out.println("Number of elements in the list after performing remove: " +myList.size());
    }
}
