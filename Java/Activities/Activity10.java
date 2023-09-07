package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Cat");
        hs.add("Mat");
        hs.add("Bat");
        hs.add("Sad");
        hs.add("Pot");
        hs.add("Mop");


        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Removing Cat from HashSet: " + hs.remove("Cat"));

        if(hs.remove("Bat")) {
            System.out.println("Bat is removed from the Set");
        } else {
            System.out.println("Bat is not present in the Set");
        }

        System.out.println("Checking if Pot is present: " + hs.contains("Pot"));
        System.out.println("Latest HashSet data: " + hs);
    }
}
