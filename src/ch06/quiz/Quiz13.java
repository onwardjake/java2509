package ch06.quiz;

public class Quiz13 {
    String name;
    String id;
    String password;
    int age;

    Quiz13(String name, String id){
        this.name = name;
        this.id = id;
    }

    public boolean login(String id, String password){
        if(id.equals("hong") && password.equals("12345"))
            return true;

        return false;
    }

    public void logout(String id){
        System.out.println(id + "님이 로그아웃 되었습니다.");
    }
}

