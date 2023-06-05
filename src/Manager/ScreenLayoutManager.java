package Manager;

import dao.ScreenLayoutDao;
import exception.DAOException;
import model.ScreenLayout;
import view.ScreenLayoutView;

import java.util.ArrayList;
import java.util.List;

public class ScreenLayoutManager {
    private ScreenLayoutDao screenLayoutDao = new ScreenLayoutDao();
    private ScreenManager screenManager = new ScreenManager();
    private ScreenLayoutView screenLayoutView = new ScreenLayoutView();

    public static List<String> generateSeatNumbers(int rows, int columns) {
        List<String> seatNumbers = new ArrayList<>();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String seatNumber = String.format("%s%d", letters.charAt(row), col + 1);
                seatNumbers.add(seatNumber);
            }
        }

        return seatNumbers;
    }

    public void generateNumber(int rows, int columns) throws DAOException {

        List<String> seatNumbers = generateSeatNumbers(rows, columns);
        screenLayoutDao.storeSeatNumbers(seatNumbers, screenManager.screenDetails());
    }

    public void screenLayoutDisplayData(int rows, int columns) throws DAOException {
        List<ScreenLayout> seatNumbers = screenLayoutDao.fetchSeatNumbersFromDatabase(screenManager.screenDetails());
        screenLayoutView.printSeatNumbers(seatNumbers, rows, columns);
    }

    public void seatNumberToBook() throws DAOException {
        ScreenLayout screenLayout = screenLayoutView.getSeatNumberToBook();
        ScreenLayout existingScreenLayout = screenLayoutDao.getSeatStatus(screenManager.screenDetails(), screenLayout.getSeatNumber());

        if (existingScreenLayout != null) {
            if (existingScreenLayout.getStatus().equals("available")) {
                String newStatus = "booked";
                existingScreenLayout.setStatus(newStatus);
                screenLayoutDao.updateSeatStatus(screenLayout.getSeatNumber(), existingScreenLayout, screenManager.screenDetails());

                System.out.println("Seat status updated successfully.");
            } else {
                System.out.println("The seat is already booked.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

}

