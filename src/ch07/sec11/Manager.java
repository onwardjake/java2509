package ch07.sec11;

public non-sealed class Manager extends Person {
    public Manager(String name){
        super(name);
    }

    @Override
    public void work(){
        System.out.println(name + "은/는 관리 감독을 합니다.");
    }
}
