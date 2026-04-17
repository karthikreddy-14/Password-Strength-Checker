import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        checkPassword(password);

        sc.close();
    }
    public static void checkPassword(String password) {
        int score = 0;
        // Conditions
        boolean length = password.length() >= 8;
        boolean upper = password.matches(".*[A-Z].*");
        boolean lower = password.matches(".*[a-z].*");
        boolean digit = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[!@#$%^&*()].*");

        if (length) score++;
        if (upper) score++;
        if (lower) score++;
        if (digit) score++;
        if (special) score++;

        // Strength Check
        if (score <= 2) {
            System.out.println("Password Strength: WEAK ❌");
        } else if (score == 3 || score == 4) {
            System.out.println("Password Strength: MEDIUM ⚠️");
        } else {
            System.out.println("Password Strength: STRONG ✅");
        }

        // Suggestions
        System.out.println("\nSuggestions:");
        if (!length) System.out.println("- Use at least 8 characters");
        if (!upper) System.out.println("- Add uppercase letters");
        if (!lower) System.out.println("- Add lowercase letters");
        if (!digit) System.out.println("- Include numbers");
        if (!special) System.out.println("- Include special characters (!@#$...)");
    }
}