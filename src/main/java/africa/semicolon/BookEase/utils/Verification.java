package africa.semicolon.BookEase.utils;

public class Verification {
    public static boolean verifyPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*)(?=.*[@$!%*#?&])[A-Za-z@$!%*#?&]{8,}$");
    }

    public static boolean verifyEmail(String email) {
        return email.matches("^([a-z0-9]+(?:[._-][a-z0-9]+)*)@([a-z0-9]+(?:[.-][a-z0-9]+)*\\.[a-z]{2,})$");
    }
}
