package ch13.sec01;

public class GenericEx {
    public static void main(String[] args) {
        Box<String> box1 = new Box<String>();
        box1.content = "Hello, world!";
        System.out.println(box1.content);

        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        System.out.println(box2.content);
    }
}
