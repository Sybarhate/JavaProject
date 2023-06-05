package validation;

public class MobileValidator {
    public boolean isValidMobileNumber(String number) {
        String pattern = "^[1-9]\\d{9}$";
        return number.matches(pattern);
    }
}

