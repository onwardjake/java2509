package quiz.d0916.abst;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double pos_x, double pos_y, double width, double height) {
        super(color, pos_x, pos_y);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle 생성자 호출");
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return width * 2 + height * 2;
    }

    @Override
    public void draw() {
        System.out.println("사각형을 그립니다. 가로 : " + width + ", 세로 : " + height + ", 색깔 : " + color);
    }

    @Override
    protected String getShapeType() {
        return "사각형";
    }
}
