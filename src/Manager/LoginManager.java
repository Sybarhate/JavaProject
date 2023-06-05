package Manager;

import common.Session;
import dao.UserDao;
import exception.DAOException;
import model.User;
import validation.Validation;
import view.LoginView;

import java.util.Scanner;

public class LoginManager {
    private LoginView loginView = new LoginView();
    private UserDao userDao = new UserDao();
    Scanner scanner = new Scanner(System.in);
    RoleManager roleManager = new RoleManager();

    public void doLogin() {
        User user = loginView.takeLoginDetails();
        boolean isEmpty;
        String otp;
        try {
            User user1 = userDao.checkUserCredential(user.getEmail(), user.getPassword());
            if (user1 == null) {
                loginView.displayLoginErrorMessage("Login Failed");
            } else if (!user1.isVerified()) {
                do {
                    System.out.println("Enter Verification code ");
                    otp = scanner.nextLine();
                    isEmpty = Validation.isEmpty(otp);
                    if (otp.equals(user1.getVerificationCode())) {
                        userDao.updateUserIsVerified(true, user1.getEmail());
                        loginView.displayLoginSuccessMessage(user1.getFirstName() + " " + user1.getLastName());
                        Session.setCurrentUser(user1);
                        roleManager.checkRole();
                    } else {
                        loginView.displayLoginErrorMessage("Verification code is wrong");
                    }
                } while (isEmpty || !otp.equals(user1.getVerificationCode()));
            } else {
                loginView.displayLoginSuccessMessage(user1.getFirstName() + " " + user1.getLastName() + " " + "\n Your Role is "+ user1.getRole_name());
                Session.setCurrentUser(user1);
                roleManager.checkRole();
            }
        } catch (DAOException ex) {
            ex.printStackTrace();
            loginView.displayLoginErrorMessage("Oops Something Went Wrong");
        }
    }
}
