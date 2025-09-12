package ch12.sec03;

public class HashCodeEx {
    public static void main(String[] args) {
        String name = "홍길동";
        String name2 = new String("홍길동");
        Student s1 = new Student(1, name);
        Student s2 = new Student(1, name2);
//        Student s1 = new Student(1, "홍길동");
//        Student s2 = new Student(1, "홍길동");


        System.err.println(s1);
        System.err.println(name2);
        if(s1 == s2)
            System.out.println("같은 주소 참조");
        else
            System.out.println("다른 주소 참조");

        if(s1.hashCode() == s2.hashCode()){
            if(s1.equals(s2)){
                System.out.println("동등 객체입니다.");
            }
            else
                System.out.println("데이터가 다르므로 동등객체가 아닙니다.");
        }
        else
            System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
    }
}
