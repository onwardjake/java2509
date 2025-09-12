package ch09.quiz06;

public class AnonymousEx {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        
        anony.vehicle.run();
        anony.method1();
        anony.method2(new Vehicle() {
            public void run() {
                System.out.println("트럭이 달립니다.");
            }
        });
    }
}
