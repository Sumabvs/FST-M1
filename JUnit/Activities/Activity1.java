package Activities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
        static ArrayList<String> list1;


        @BeforeEach
        void setUp() throws Exception {
            list1 = new ArrayList<String>();
            list1.add("Hello");
            list1.add("World");
            System.out.println("Added to list");
        }


        @Test
        public void insertTest() {

            assertEquals(2, list1.size(), "Wrong size");
            list1.add(2, "welcome");
            assertEquals(3, list1.size(), "Wrong size");
            assertEquals("Hello", list1.get(0), "Wrong element");
            assertEquals("World", list1.get(1), "Wrong element");
            assertEquals("welcome", list1.get(2), "Wrong element");
        }

        @Test
        public void replaceTest() {

            list1.set(1, "welcome");
            assertEquals(2, list1.size(), "Wrong size");
            assertEquals("Hello", list1.get(0), "Wrong element");
            assertEquals("welcome", list1.get(1), "Wrong element");
        }
}

