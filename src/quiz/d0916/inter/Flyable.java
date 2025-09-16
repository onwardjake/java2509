package quiz.d0916.inter;

public interface Flyable {
    public static final double MAX_ALTITUDE = 10000.0;

    void fly(); // public abstract 생략
    void land();

    // Java 8부터 가능한 default 메소드
    default void checkWeather() {
        System.out.println("날씨를 확인합니다.");
    }
}
