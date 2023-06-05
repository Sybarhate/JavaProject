package common;

import java.util.InputMismatchException;
import java.util.Scanner;

//MenuInput
//InputHandler
public class MenuHandler {

    // Integer when it mandatory
    public static int getNumberInput() {
        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

        }catch (InputMismatchException ex) {
           // System.out.println("enter number");
            getNumberInput();

        }
        return choice;
    }

    /***
     * Use this method when input is mandatory
     * @return
     */
    public static String takeStringInput() {
        return takeStringInput(false);
    }

    /***
     * Use this method when input is optional or mandaotory
     * @param isOptional Pass false in case of mandatory \n Pass true  in case of optinal.
     * @return Input value
     */
    public static String takeStringInput(boolean isOptional) {

        String value = null;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        if (!isOptional) {
            if (value == null || value.trim().isEmpty()) {
                System.out.println("please enter value");
                value = takeStringInput(false);
            }
        }
        return value;
    }
}

