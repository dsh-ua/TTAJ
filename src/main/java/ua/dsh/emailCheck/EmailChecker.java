package ua.dsh.emailCheck;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z][a-zA-Z0-9.]*[a-zA-Z0-9]@[a-zA-Z0-9]{2,}(\\.[a-zA-Z]{2,})+$");
    public static boolean checkEmail(String text) {
        if (text == null) {
        return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(text);
        return matcher.matches();
    }
}

/*
In the main branch of the maven project, prepare a class with the checkEmail(String text) method to check
 the correctness of the email address. Use regular expressions to check email address.
•	A valid username in an email must start with a letter and end with a letter or number,
    may contain Latin letters, numbers and a dot.
•	There must be at least two domain levels after the @ symbol.
•	The top-level domain must be at least two letters long.
In the test branch of the project, write a class with a set of tests for the checkEmail(String text) method.
 Upload the project to your personal GitHub or Google Drive and add a link as an answer.
*/
