package common;

import java.util.Scanner;

public class HidePassword {

    public String readPassword(Scanner scanner) {
        System.out.println(scanner);
        String password = "";
        if (scanner.hasNextLine()) {
            password = scanner.nextLine();
            // Mask the password characters
            System.out.print("\033[H\033[2J"); // Clear the console
            System.out.flush();
            System.console().writer().print("Enter your password: ");
            for (int i = 0; i < password.length(); i++) {
                System.console().writer().print("*");
            }
            System.console().writer().println();
        }
        return password;
    }
}
