package africa.semicolon.BookEase.utils;

public class Verification {
    public static boolean verifyPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$");
    }

    public static boolean verifyEmail(String email) {
        return email.matches("^([a-z0-9]+(?:[._-][a-z0-9]+)*)@([a-z0-9]+(?:[.-][a-z0-9]+)*\\.[a-z]{2,})$");
    }
}
