package za.ac.iie.prog5121;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Handles all logic for user registration and login.
public class Login {

    private String storedUsername;
    private String storedPassword;
    private String storedFirstName;
    private String storedLastName;

    // Checks if the username format is correct (contains '_' and is <= 5 chars).
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Checks if the password meets the complexity rules.
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "!@#$%^&*()_+=<>?";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (specialCharacters.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }
        return hasCapitalLetter && hasNumber && hasSpecialChar;
    }
    
    // Reference for the regular expression-based method below:
    // Google. (2024). Gemini [Large language model]. Retrieved from https://gemini.google.com
    // Checks if the cell phone number has a valid international format.
    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellNumber);
        return matcher.matches();
    }

    // Registers a user if the username and password are valid.
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters long.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.storedFirstName = firstName;
        this.storedLastName = lastName;
        return "User has been registered successfully.";
    }

    // Checks if the entered login details match the stored details.
    public boolean loginUser(String username, String password) {
        return storedUsername != null && storedUsername.equals(username) && storedPassword.equals(password);
    }

    // Returns the correct message for a successful or failed login.
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + storedFirstName + "," + storedLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}