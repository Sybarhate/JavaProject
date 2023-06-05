package validation;

public class Validation {

    static EmailValidator emailValidation = new EmailValidator();
    static MobileValidator mobileValidation = new MobileValidator();

    public static boolean isEmpty(String val) {
        if (val == null || val.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmailValid(String emailId) {

        return emailValidation.validate(emailId);
    }

    public static boolean isMobileValid(String mobileNo) {
        return mobileValidation.isValidMobileNumber(mobileNo);
    }
}
