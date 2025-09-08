package ch07.sec11;

public final class Employee extends Person {
    public Employee(String name){
        super(name);
    }

    @Override
    public void work(){
        System.out.println(name + "은/는 제품을 생산합니다.");
    }

}
