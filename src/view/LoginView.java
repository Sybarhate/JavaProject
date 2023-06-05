package view;

import common.MenuHandler;
import model.User;

public class LoginView {
    private User user = new User();

    public User takeLoginDetails() {
        System.out.print("Enter your email: ");
        user.setEmail(MenuHandler.takeStringInput());

        System.out.print("enter your password: ");
        user.setPassword(MenuHandler.takeStringInput());
        return user;
    }

    public void displayLoginSuccessMessage(String message) {
        System.out.println("Welcome " + message);
    }

    public void displayLoginErrorMessage(String message) {
        System.out.println("Error:" + message);
    }
}



