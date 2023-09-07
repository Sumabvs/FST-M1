package Activities;

public class Activity2 {

    public static void main(String[] args) {

        double[] values = {10, 77, 10, 54, -11, 10};

        double searchvalue = 10;
        double addedvalue = 30;
        System.out.println("Result is:"+verify(values,searchvalue,addedvalue));
    }
        public static boolean verify(double[] values, double searchvalue, double addedvalue ){

            double sum = 0;
            for (int i = 0; i <values.length; i++) {
                if (values[i] == searchvalue) {
                    sum += values[i];
                    System.out.println(sum);
                }
                //if (values[i] > searchvalue) {
                 //   break;
                //}
            }

            return sum == addedvalue;
        }

}
