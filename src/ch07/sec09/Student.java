package ch07.sec09;

public class Student extends Person {
    public int studentId;

    public Student(String name, int studentId){
        super(name);
        this.studentId = studentId;
    }

    public void study(){
        System.out.println("공부를 합니다.");
    }
}
