package ch08.quiz;

public class SoundableExample {
    public static void printSound(Soundable soundable){
        System.out.println(soundable.sound());
    }

    public static void main(String[] args) {
        printSound(new Dog());
        printSound(new Cat());
    }
}
