package ch08.quiz;

public class Dog implements Soundable{
    @Override
    public String sound(){
        return new String("멍멍");
    }
}
