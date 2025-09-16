package ch13.quiz02;

public class ContainerEx {
    public static void main(String[] args) {
        Container<String> c1 = new Container<>();
        c1.set("홍길동");
        System.out.println(c1.get());

        Container<Integer> c2 = new Container<Integer>();
        c2.set(9);
        System.out.println(c2.get());
    }
}
