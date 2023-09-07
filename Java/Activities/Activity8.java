package Activities;


class CustomException extends Exception{
    private String message;

    CustomException(String messagevalue) {
        this.message = messagevalue;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
public class Activity8 {

    static void exceptionTest(String strmsg) throws CustomException {
        if(strmsg == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(strmsg);
        }
    }
    public static void main(String[] a){
        try {

            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException mg) {
            System.out.println("Inside catch block: " + mg.getMessage());
        }
    }


}
