package ch07.sec11;

public class SealedEx {
    public static void main(String[] args) {
        Person p1 = new Person("인간");
        Employee e1 = new Employee("근로자");
        Manager m1 = new Manager("매니저");
        Director d1 = new Director("디렉터");

        p1.work();
        e1.work();
        m1.work();
        d1.work();
    }
}
