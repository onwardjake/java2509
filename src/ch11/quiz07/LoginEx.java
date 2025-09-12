package ch11.quiz07;

public class LoginEx {
    public static void main(String[] args) {
        try {
            login("white", "12345");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            login("blue", "1234");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(String id, String password) throws WrongPasswordException, NotExistIDException {
        if(!id.equals("blue"))
            throw new NotExistIDException("존재하지 않는 ID입니다.");

        if(!password.equals("12345"))
            throw new WrongPasswordException("비밀번호가 틀렸습니다.");
    }
}
