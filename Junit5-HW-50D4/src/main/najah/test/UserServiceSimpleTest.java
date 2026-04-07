package main.najah.test;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class UserServiceSimpleTest {

    UserService service = new UserService();

    @Test
    @DisplayName("Valid Email")
    void testValidEmail() {
        assertTrue(service.isValidEmail("test@mail.com"));
    }

    @Test
    @DisplayName("Invalid Email")
    void testInvalidEmail() {
        assertFalse(service.isValidEmail("invalid"));
    }

    @Test
    @DisplayName("Auth Success")
    void testAuthSuccess() {
        assertTrue(service.authenticate("admin","1234"));
    }

    @Test
    @DisplayName("Auth Failure")
    void testAuthFail() {
        assertFalse(service.authenticate("user","wrong"));
    }
}