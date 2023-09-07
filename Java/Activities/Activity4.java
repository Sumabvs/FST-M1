package Activities;

import java.util.Arrays;

public class Activity4 {

    public static void ascendingorder(int[] list){

        int size = list.length, i;

        for (i = 1; i < size; i++) {
            int temp = list[i];
            int j = i - 1;

            while (j >= 0 && temp < list[j]) {
                list[j + 1] = list[j];
                --j;
            }
            list[j + 1] = temp;
        }
    }

    public static void main(String[] args){
        int[] numbers={2,5,3,6,7,9,10,11};
        System.out.println("List of array values before sorting:" + Arrays.toString(numbers));
        ascendingorder(numbers);
        System.out.println("List of array values after sorting:" + Arrays.toString(numbers));


    }
}
