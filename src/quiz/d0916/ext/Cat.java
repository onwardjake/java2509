package quiz.d0916.ext;

public class Cat extends Animals {
    private boolean isIndoorCat;

    public Cat(String name, int age, boolean isIndoorCat){
        super(name, age);
        this.isIndoorCat = isIndoorCat;
        System.out.println("Cat class 생성자 호출");
    }

    @Override
    public void makeSound() {
        System.out.println(name + "이(가) 야옹하고 웁니다.");
    }

    public void climb() {
        System.out.println(name + "이(가) 캣타워를 올라갑니다.");
    }

    @Override
    public void eat() {
        System.out.println(name + "이(가) 참치캔을 먹습니다.");
    }

    @Override
    public void displayAnimalInfo() {
        super.displayAnimalInfo();
        System.out.println("이 고양이는 실" + (isIndoorCat ? "내" : "외") + "에서 생활하는 고양이입니다.");
    }
}
