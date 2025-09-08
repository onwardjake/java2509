package ch07.sec10;

public class AbstractMethodEx {
    public static void main(String[] args) {
        Dog dog = new Dog("리온");
        dog.breath();
        dog.sound();

        Cat cat = new Cat("체리");
        cat.breath();
        cat.sound();

        animalSound(dog);
        animalSound(cat);
    }

    public static void animalSound(Animal animal){
        animal.sound();
    }
}
