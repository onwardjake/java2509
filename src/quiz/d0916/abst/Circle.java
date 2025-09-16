package quiz.d0916.abst;

public class Circle extends Shape{
    private double radius;

    public Circle(String color, double pos_x, double pos_y, double radius) {
        super(color, pos_x, pos_y);
        this.radius = radius;
        System.out.println("Circle 생성자 호출");
    }

    @Override
    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("원을 그립니다. 반지름 : " + radius + ", 색깔 : " + color);
    }

    @Override
    protected String getShapeType() {
        return "원";
    }
}
