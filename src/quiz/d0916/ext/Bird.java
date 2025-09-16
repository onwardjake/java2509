package quiz.d0916.ext;

import quiz.d0916.inter.Flyable;

public class Bird extends Animals implements Flyable {
    public Bird(String name, int age) {
        super(name, age);
        System.out.println("Bird 생성자 호출");
    }

    @Override
    public void fly() {
        System.out.println(name + "이(가) 날아갑니다. 최고로 날 수 있는 높이는 " + Flyable.MAX_ALTITUDE + " 미터입니다.");
    }

    @Override
    public void land() {
        System.out.println(name + "이(가) 땅에 착지합니다.");
    }
}
