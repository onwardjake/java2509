package ch11.quiz07;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {}
    public WrongPasswordException(String message) {
        super(message);
    }
}
