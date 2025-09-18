package za.ac.iie.prog5121;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login loginSystem = new Login();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- User Registration ---");

        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();

        String username;
        while (true) {
            System.out.print("Enter a username (must contain '_' and be 5 chars or less): ");
            username = scanner.nextLine();
            if (loginSystem.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please try again.");
            }
        }

        String password;
        while (true) {
            System.out.print("Enter a password (>=8 chars, with a capital, number, & special character): ");
            password = scanner.nextLine();
            if (loginSystem.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                // This is the updated error message
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }
        
        String cellNumber;
        while (true) {
            System.out.print("Enter a cell phone number (e.g., +27821234567): ");
            cellNumber = scanner.nextLine();
            if (loginSystem.checkCellPhoneNumber(cellNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        String registrationMessage = loginSystem.registerUser(username, password, firstName, lastName);
        System.out.println("\n" + registrationMessage + "\n");

        System.out.println("--- User Login ---");
        boolean isLoginSuccess = false;
        while (!isLoginSuccess) {
            System.out.print("Please enter your username to login: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Please enter your password to login: ");
            String loginPassword = scanner.nextLine();

            isLoginSuccess = loginSystem.loginUser(loginUsername, loginPassword);
            String loginStatusMessage = loginSystem.returnLoginStatus(isLoginSuccess);
            System.out.println("\n" + loginStatusMessage + "\n");
        }

        scanner.close();
    }
}