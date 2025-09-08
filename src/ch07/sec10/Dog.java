package ch07.sec10;

public class Dog extends Animal {
    public Dog(String name){
        super(name);
        System.out.println("Dog 생성자");
    }

    @Override
    public void sound(){
        System.out.println("멍멍!");
    }
}
