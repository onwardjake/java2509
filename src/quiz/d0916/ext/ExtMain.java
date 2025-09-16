package quiz.d0916.ext;

public class ExtMain {
    public ExtMain() {
        Cat cat = new Cat("체리", 1, true);
        cat.displayAnimalInfo();
        cat.makeSound();
        cat.eat();
        cat.climb();
        cat.sleep();

        Dog dog = new Dog("리온", 5, "진돗개");
        dog.displayAnimalInfo();
        dog.makeSound();
        dog.eat();
        dog.wagTail();
        dog.sleep();
    }
}
