package quiz.d0916.abst;

public abstract class Shape {
    protected String color;
    protected double pos_x, pos_y;

    public Shape(String color, double pos_x, double pos_y) {
        this.color = color;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        System.out.println("Shape 생성자 호출");
    }

    // 일반 메소드
    public void move(double new_x, double new_y) {
        pos_x = new_x;
        pos_y = new_y;
        System.out.println(getShapeType() + " 도형의 위치가 이동되었습니다. 새 좌표는 (" + pos_x + ", " + pos_y + ") 입니다.");
    }

    // 추상 메소드
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void draw();
    protected abstract String getShapeType();

    // 템플릿 메소드 패턴
    public final void displayShapeInfo(){
        System.out.println("=== " + getShapeType() + " 정보 ===");
        System.out.println("색깔 : " + color);
        System.out.println("좌표 : (" + pos_x + ", " + pos_y + ")");
        System.out.println("넓이 : " + calculateArea());
        System.out.println("둘레 : " + calculatePerimeter());
        draw();
    }
}
