package ua.dsh.emailCheck;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EmailCheckerTest {
    @Test
    public void testValidEmail() {
        assertTrue(EmailChecker.checkEmail("valid.email@ukr.net"));
        assertTrue(EmailChecker.checkEmail("valid.email@gmail.com"));
        assertTrue(EmailChecker.checkEmail("valid77.email@ukr.net"));
        assertTrue(EmailChecker.checkEmail("valid.email.77@ukr.net"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(EmailChecker.checkEmail("user.name@"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail.c"));
        assertFalse(EmailChecker.checkEmail("user.name@.com"));
        assertFalse(EmailChecker.checkEmail("user.name@com"));
        assertFalse(EmailChecker.checkEmail(".username@gmail.com"));
        assertFalse(EmailChecker.checkEmail("user..name@gmail.com.u"));
        assertFalse(EmailChecker.checkEmail("user.name@.gmail.com"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail..com"));
    }

    @Test
    public void testValidUsername() {
        assertTrue(EmailChecker.checkEmail("username@gmail.com"));
        assertTrue(EmailChecker.checkEmail("user.name@gmail.com"));
        assertTrue(EmailChecker.checkEmail("user.name.123@gmail.com"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(EmailChecker.checkEmail(".username@gmail.com"));
        assertFalse(EmailChecker.checkEmail("username.@gmail.com"));
        assertFalse(EmailChecker.checkEmail("5user.name..123@gmail.com"));
    }

    @Test
    public void testValidDomain() {
        assertTrue(EmailChecker.checkEmail("username@gmail.com"));
        assertTrue(EmailChecker.checkEmail("user.name@gmail.co.uk"));
        assertTrue(EmailChecker.checkEmail("user.name@ukr.net"));
    }

    @Test
    public void testInvalidDomain() {
        assertFalse(EmailChecker.checkEmail("username@localhost"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail.c"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail."));
        assertFalse(EmailChecker.checkEmail("user.name@gmail.c@om"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail.c_om"));
        assertFalse(EmailChecker.checkEmail("user.name@gmail.12"));
    }
    @Test
    public void testNullString (){
        assertFalse(EmailChecker.checkEmail(null));
    }
}
