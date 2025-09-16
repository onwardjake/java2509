package quiz.d0916.inter;

public interface Swimmable {
    void swim();
    public abstract void dive();

    default void checkWaterTemp() {
        System.out.println("수온을 확인합니다.");
    }
}
