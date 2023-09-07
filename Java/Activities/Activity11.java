package Activities;

import java.util.HashMap;

public class Activity11 {

    public static void main(String args[])
    {
        HashMap<Integer,String> hashp=new HashMap<Integer,String>();
        hashp.put(1,"Blue");
        hashp.put(2,"Red");
        hashp.put(3,"Yellow");
        hashp.put(4,"Pink");
        hashp.put(5,"Black");
        hashp.put(6,"White");
        System.out.println("Hash Map data: " +hashp);
        System.out.println("Removing one color: "+hashp.remove("Pink"));
        if(hashp.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        System.out.println("Size of Map is: "+hashp.size());
    }
}
