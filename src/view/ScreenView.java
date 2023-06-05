package view;

import common.MenuHandler;
import model.Screen;

public class ScreenView {
    private Screen screen = new Screen();

    public int takeRow() {
        System.out.println("Enter Number of Rows ");
        screen.setNoOfRows(MenuHandler.getNumberInput());
        return screen.getNoOfRows();
    }

    public int takeColumn() {
        System.out.println("Enter Number of Columns ");
        screen.setNoOfColumns(MenuHandler.getNumberInput());
        return screen.getNoOfColumns();
    }

    public void displayScreenDetails(Screen screen) {
        System.out.println("ScreenId" + screen.getScreenId());
        System.out.println("CinemaId" + screen.getCinemaId());
        System.out.println("rows" + screen.getNoOfRows());
        System.out.println("column" + screen.getNoOfColumns());
    }

//    public int menuList() {
//        int choice;
//        System.out.println("Welcome");
//        System.out.println("1. Add Screen");
//        System.out.println("2. Add Movie");
//        System.out.println("Enter your choice: ");
//        choice = MenuHandler.getNumberInput();
//        return choice;
//    }
}
