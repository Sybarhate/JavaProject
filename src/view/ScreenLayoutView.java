package view;

import common.MenuHandler;
import model.ScreenLayout;
import java.util.List;

public class ScreenLayoutView {
    ScreenLayout screenLayout = new ScreenLayout();

    public void printSeatNumbers(List<ScreenLayout> seatNumbers, int rows, int columns) {
        System.out.println("Seat Numbers:");

        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (index < seatNumbers.size()) {
                    System.out.print(seatNumbers.get(index).getSeatNumber() + " ");
                    index++;
                }
            }
            System.out.println();
        }
    }

    public ScreenLayout getSeatNumberToBook() {
        System.out.println("Enter seat number to book ");
        screenLayout.setSeatNumber(MenuHandler.takeStringInput());
        return screenLayout;

    }

}


//
//    public class SeatNumberGenerator {
//        private static final String AVAILABLE = "O";
//        private static final String BOOKED = "X";
//
////        public static List<String> generateSeatNumbers(int rows, int columns) {
////            List<String> seatNumbers = new ArrayList<>();
////            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
////
////            for (int row = 0; row < rows; row++) {
////                for (int col = 0; col < columns; col++) {
////                    String seatNumber = String.format("%s%d", letters.charAt(row), col + 1);
////                    seatNumbers.add(seatNumber);
////                }
////            }
////
////            return seatNumbers;
////        }
//
//        public static List<String> generateInitialSeatStatus(int totalSeats) {
//            List<String> seatStatus = new ArrayList<>();
//
//            for (int i = 0; i < totalSeats; i++) {
//                seatStatus.add(AVAILABLE);
//            }
//
//            return seatStatus;
//        }
//
//        public static void bookSeat(List<String> seatStatus, int seatIndex) {
//            seatStatus.set(seatIndex, BOOKED);
//        }
//
////        public static void displaySeatStatus(List<String> seatNumbers, List<String> seatStatus) {
////            if (seatNumbers.size() != seatStatus.size()) {
////                System.out.println("Error: Seat numbers and seat status don't match.");
////                return;
////            }
////
////            for (int i = 0; i < seatNumbers.size(); i++) {
////                String seatNumber = seatNumbers.get(i);
////                String status = seatStatus.get(i);
////
////                if (status.equals(AVAILABLE)) {
////                    System.out.printf("%s ", seatNumber);
////                } else if (status.equals(BOOKED)) {
////                    System.out.printf("[%s] ", seatNumber);
////                }
////            }
////            System.out.println();
////        }
//
////        public static void main(String[] args) {
////            int rows = 2;
////            int columns = 3;
////            List<String> seatNumbers = generateSeatNumbers(rows, columns);
//           // List<String> seatStatus = generateInitialSeatStatus(seatNumbers.size());
//
//            // Book a seat
//           // int seatIndexToBook = 2; // Example: Seat index 2 (A3) is booked
////            bookSeat(seatStatus, seatIndexToBook);
//
//            // Display seat status
//           // displaySeatStatus(seatNumbers, seatStatus);
//        }
//    }
//
//}
