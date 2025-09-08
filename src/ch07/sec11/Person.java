package ch07.sec11;

public sealed class Person permits Employee, Manager {
    public String name;

    public Person(String name){
        this.name = name;
    }

    public void work(){
        System.out.println(name + "은/는 할 일이 정의되지 않았습니다.");
    }
}
