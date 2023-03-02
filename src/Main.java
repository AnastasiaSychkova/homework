public class Main {
    public static void main(String[] args) {
        finish("oooooooooooo", "jfjkjkgR55", "jfjkjkgR");
        finish("oooooooooooo", "bggbg655", "bggbg655");
    }

    public static boolean finish(String login, String password, String repeatPassword) {
        try {
            checkLogin(login);
            checkPassword(password, repeatPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void checkLogin(String login) {
        if (isValidLength(login) && hasOnlyValidSymbols(login)) {
            System.out.println("Верный логин");
        } else {
            throw new WrongLoginException("Неправильный логин");
        }
    }

    private static void checkPassword(String password, String repeatPassword) {
        if (hasOnlyValidSymbols(password) && equalsPassword(password, repeatPassword) && isValidLength(password)) {
            System.out.println("Верный пароль");
        } else {
            throw new WrongPasswordException("Неправильный пароль");
        }
    }

    private static boolean equalsPassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }

    private static boolean hasOnlyValidSymbols(String s) {
        final String alphabet = "abcdefghigklmnopqrstuvwxyz0123456789_";
        for (int i = 0; i < s.length(); i++) {
            if (!alphabet.contains(String.valueOf(s.charAt(i)).toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidLength(String s) {
        return s.length() <= 20;
    }

}