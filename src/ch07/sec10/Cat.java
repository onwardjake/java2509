package ch07.sec10;

public class Cat extends Animal {
    public Cat(String name){
        super(name);
        System.out.println("Cat 생성자");
    }

    public void sound(){
        System.out.println("야옹!");
    }
}
