package quiz.d0916.poly;

import quiz.d0916.ext.Animals;
import quiz.d0916.ext.Cat;
import quiz.d0916.ext.Dog;

public class PolymorphismMain {
    public PolymorphismMain() {
        // 다형성 배열
        Animals[] animals = {
                new Dog("티거", 4, "늑대개"),
                new Cat("잔나비", 2, true),
                new Dog("부용", 3, "늑대개 믹스"),
                new Cat("살쾡이", 6, false)
        };

        System.out.println("=== 동물의 울음소리 ===");
        for (Animals animal : animals){
            animal.makeSound();
        }

        System.out.println("=== 동물별 특별 행동 ===");
        for(Animals animal : animals) {
            if(animal instanceof Dog) {
                ((Dog)animal).wagTail();
            }
            else if(animal instanceof Cat) {
                ((Cat)animal).climb();
            }
        }

        // 다형성 메소드 호출
        playWithAnimal(new Dog("차우", 3, "늑대개 믹스"));
        playWithAnimal(new Cat("체리", 1, true));
    }

    public static void playWithAnimal(Animals animal){
        System.out.println("\n" + animal.getName() + "과 놀아주기");
        animal.makeSound();
        animal.eat();

        if(animal instanceof Dog) {
            ((Dog)animal).wagTail();
        }
        else if(animal instanceof Cat) {
            ((Cat)animal).climb();
        }
    }
}
