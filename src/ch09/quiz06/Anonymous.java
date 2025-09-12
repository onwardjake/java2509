package ch09.quiz06;

public class Anonymous {
    Vehicle vehicle = new Vehicle() {
        public void run() {
            System.out.println("자전거가 달립니다.");
        }
    };

    public void method1() {
        Vehicle localV = new Vehicle() {
            public void run() {
                System.out.println("승용차가 달립니다.");
            }
        };
        localV.run();
    }

    public void method2(Vehicle v) {
        v.run();
    }
}
