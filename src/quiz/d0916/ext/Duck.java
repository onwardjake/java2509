package quiz.d0916.ext;

import quiz.d0916.inter.Swimmable;
import quiz.d0916.inter.Walkable;

public class Duck extends Animals implements Swimmable, Walkable {
    public Duck(String name, int age) {
        super(name, age);
        System.out.println("Duck 생성자 호출");
    }

    @Override
    public void swim() {
        System.out.println(name + "이(가) 수영을 합니다.");
    }

    @Override
    public void dive() {
        System.out.println(name + "이(가) 잠수를 합니다.");
    }

    @Override
    public void walk() {
        System.out.println(name + "이(가) 걷습니다.");
    }

    @Override
    public void run() {
        System.out.println(name + "이(가) 뜁니다.");
    }
}
