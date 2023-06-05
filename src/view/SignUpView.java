package view;

import common.MenuHandler;
import dao.UserDao;
import exception.DAOException;
import model.User;
import validation.Validation;

public class SignUpView {

    public User takeSignUpDetails() throws DAOException {
        User user = new User();
        UserDao userDao = new UserDao();
        boolean isEmpty;
        boolean isValidEmail;
        boolean isValidMobile;
        int counter=0;

            System.out.print("Enter your First Name: ");
            user.setFirstName(MenuHandler.takeStringInput());

            System.out.print("Enter your Last Name: ");
            user.setLastName(MenuHandler.takeStringInput());

        do {
            System.out.print("Enter your email: ");
            user.setEmail(MenuHandler.takeStringInput());
            isEmpty = Validation.isEmpty(user.getEmail());
            isValidEmail = Validation.isEmailValid(user.getEmail());
            if (isEmpty || !isValidEmail) {
                System.out.println("Invalid input, enter again");
            } else if (userDao.isEmailExists(user.getEmail())) {
                System.out.println("Email already exists in the database.");
            } else {
                break;
            }
        } while (isEmpty || !isValidEmail || userDao.isEmailExists(user.getEmail()));

        do {
            System.out.print("Enter your Mobile Number: ");
            user.setMobileNumber(MenuHandler.takeStringInput(true));
            //isEmpty = Validation.isEmpty(user.getMobileNumber());
            isValidMobile = Validation.isMobileValid(user.getMobileNumber());
            if (!isValidMobile) {
                System.out.println("Invalid input, enter again");
            } else if (userDao.isMobileExists(user.getMobileNumber())) {
                System.out.println("Mobile Number already exists in the database.");
            } else {
                break;
            }
            counter++;
        } while (counter<3 && !isValidMobile || userDao.isMobileExists(user.getMobileNumber()));


            System.out.print("Enter your Date of Birth: ");
            user.setDateOfBirth(MenuHandler.takeStringInput());


            System.out.print("Enter your gender: ");
            user.setGender(MenuHandler.takeStringInput(true));


            System.out.print("Enter your Address: ");
            user.setAddress(MenuHandler.takeStringInput(true));


            System.out.print("Enter your Password: ");
           // user.setPassword(hidePassword.readPassword(s1));
            user.setPassword(MenuHandler.takeStringInput());



        System.out.print("Enter your Role-[ 1.Super Admin, 2.Cinema Admin, 3.User]: ");
        user.setRoleId(MenuHandler.getNumberInput());
        return user;
    }

    public void displaySignUpSuccessMessage() {
        System.out.println("Account created successfully");
    }

    public void displaySignUpErrorMessage(String message) {
        System.out.println("Error:" + message);
    }
}