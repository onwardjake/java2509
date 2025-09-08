package ch07.sec11;

public class Director extends Manager {
    public Director(String name){
        super(name);
    }

    public void work(){
        System.out.println(name + "은/는 전체 업무를 조율합니다.");
    }
}
