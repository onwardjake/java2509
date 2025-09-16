package quiz.d0916.ext;

public class Animals {
    protected String name;
    protected int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animals class 생성자 호출");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println(name + "이(가) 먹습니다.");
    }

    public void sleep() {
        System.out.println(name + "이(가) 잡니다.");
    }

    public void makeSound() {
        System.out.println(name + "이(가) 소리를 냅니다.");
    }

    public void displayAnimalInfo() {
        System.out.println("이름 : " + name + ", 나이 : " + age);
    }
}
