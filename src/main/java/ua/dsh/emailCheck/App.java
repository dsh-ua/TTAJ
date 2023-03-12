package ua.dsh.emailCheck;
import static ua.dsh.emailCheck.EmailChecker.checkEmail;

public class App {
    public static void main(String[] args) {
        String email1 = new String("test.email@gmail.com");
        String email2 = new String("fail.email.1234@do.m");
        System.out.println(email1 + "\t" + checkEmail(email1));
        System.out.println(email2 + "\t" + checkEmail(email2));
    }
}
