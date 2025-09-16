package quiz.d0916.ext;

public class Dog extends Animals{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
        System.out.println("Dog 생성자 호출");
    }

    @Override
    public void makeSound() {
        System.out.println(name + "이(가) 멍멍하고 짖습니다.");
    }

    public void wagTail() {
        System.out.println(name + "이(가) 꼬리를 풍차처럼 돌리고 있습니다. 많이 반가운가봐요.");
    }

    @Override
    public void eat() {
        System.out.println(name + "이(가) 뼈다귀를 와그작 와그작 씹어먹고 있습니다.");
    }

    @Override
    public void displayAnimalInfo(){
        super.displayAnimalInfo();
        System.out.println("품종 : " + breed);
    }
}
