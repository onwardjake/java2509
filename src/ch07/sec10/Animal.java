package ch07.sec10;

public abstract class Animal {
    String name;

    public Animal(String name){
        this.name = name;
        System.out.println("Animal 생성자");
    }

    public void breath(){
        System.out.println(name + "이(가) 숨을 쉽니다.");
    }

    public abstract void sound();
}
