package quiz.d0916.abst;

public class AbstMain {

    public AbstMain() {
        Circle circle = new Circle("빨간색", 5.6, 9.9, 3.5);
        circle.displayShapeInfo();

        Rectangle rect = new Rectangle("녹색", 3.4, 8.5, 4.0, 5.5);
        rect.displayShapeInfo();
    }

}
