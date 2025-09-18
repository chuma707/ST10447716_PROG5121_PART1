package za.ac.iie.prog5121; 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testCheckUserName_CorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_IncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity_SuccessfullyCaptured() {
        assertTrue(login.checkPasswordComplexity("Ch&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_FailsComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser_ReturnsCorrectMessageForConditionsMet() {
        String expected = "User has been registered successfully.";
        String actual = login.registerUser("user_", "P@ssword123", "First", "Last");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_ReturnsMessageForIncorrectPassword() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser("user_", "password", "First", "Last");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testLoginUser_SuccessfulLogin() {
        login.registerUser("user_", "P@ssword123", "First", "Last");
        assertTrue(login.loginUser("user_", "P@ssword123"));
    }

    @Test
    public void testLoginUser_FailedLogin() {
        login.registerUser("user_", "P@ssword123", "First", "Last");
        assertFalse(login.loginUser("user_", "wrongpassword"));
    }
}
