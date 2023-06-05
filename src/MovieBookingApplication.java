import Manager.LoginManager;
import Manager.SignUpManager;
import constant.AppConstant;
import exception.DAOException;
import common.MenuHandler;

public class MovieBookingApplication {

    public static void main(String[] args) throws DAOException {
        int number;
        do {
            System.out.println("Welcome to the Movie Booking Application!");
            System.out.println("Enter your choice: ");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Exit ");
            number = MenuHandler.getNumberInput();
            switch (number) {
                case AppConstant.MENU_SIGNUP:
                    SignUpManager signUpManager = new SignUpManager();
                    signUpManager.doSignUp();
                    break;
                case AppConstant.MENU_LOGIN:
                    LoginManager loginManager = new LoginManager();
                    loginManager.doLogin();
                    break;
                case AppConstant.EXIT_MENU:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice...");
            }
            number = 0;
        } while (number != 3);
    }
}

