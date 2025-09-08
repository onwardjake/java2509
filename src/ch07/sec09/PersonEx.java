package ch07.sec09;

public class PersonEx {
    public static void personInfo(Person person){
        System.out.println("이름 : " + person.name);
        person.walk();

        // person이 Student 객체 타입인지를 확인하고, 맞으면 student 변수를 사용한다.
        if(person instanceof Student student){
            System.out.println("학생번호 : " + student.studentId);
            student.study();
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("이정재");
        personInfo(p1);

        Student s1 = new Student("학생", 1111);
        personInfo(s1);
    }
}
