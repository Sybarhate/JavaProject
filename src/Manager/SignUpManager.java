package Manager;

import common.EmailService;
import common.Utility;
import dao.UserDao;
import exception.DAOException;
import model.User;
import view.SignUpView;

public class SignUpManager {

    private SignUpView signUpView = new SignUpView();
    private UserDao userDao = new UserDao();
    private EmailService emailService = new EmailService();

    public void doSignUp() throws DAOException {
        User user = signUpView.takeSignUpDetails();
        try {
            String verificationCode = Utility.generateVerificationCode();
            user.setVerificationCode(verificationCode);
            userDao.createUser(user);
            sendMail(user);
            signUpView.displaySignUpSuccessMessage();
        } catch (DAOException ex) {
            signUpView.displaySignUpErrorMessage("Oops Something went wrong..");
        }

    }

    private void sendMail(User user) {
        StringBuilder mailContent = new StringBuilder();
        mailContent.append("<H1>")
                .append("Hi, ").append(user.getFirstName()).append(" ").append(user.getLastName())
                .append("</H1>")
                .append("Your verification code :").append(user.getVerificationCode());
        emailService.sendMail(user.getEmail(), "Movie Booking: verification code", mailContent.toString());
    }

}
