package quiz.d0916.inter;

import quiz.d0916.ext.Bird;
import quiz.d0916.ext.Duck;

public class InterfaceMain {
    public InterfaceMain() {
        Bird bird = new Bird("짹짹이", 3);
        bird.checkWeather();
        bird.fly();
        bird.land();

        Duck duck = new Duck("도날드 덕", 99);
        duck.checkWaterTemp();
        duck.swim();
        duck.dive();
        duck.walk();
        duck.run();
    }
}
