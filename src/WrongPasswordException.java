public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Неправильный пароль");
    }
}