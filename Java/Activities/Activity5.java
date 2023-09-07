package Activities;


abstract class Book{
    String title;
    abstract void setTitle(String a);
     String getTitle(){

        return title;
    }
}
class MyBook extends Book{

    public void setTitle(String a){
        title=a;
    }
}
public class Activity5 {
    public static void main(String[] args){
        String title="My Journey";
        MyBook newNoval=new MyBook();
        newNoval.setTitle(title);
        System.out.println("Title of book is: " +newNoval.getTitle());
    }
}