package operations;

import Manager.CinemaManager;
import Manager.MovieManager;
import Manager.ScreenLayoutManager;
import Manager.ScreenManager;
import constant.AppConstant;
import exception.DAOException;
import view.CinemaView;
import view.ScreenView;

public class Operations {
    CinemaManager cinemaManager = new CinemaManager();
    int row, column,choice;

    public void checkCinemaUserRoleOperations() throws DAOException {
        CinemaView cinemaView=new CinemaView();
        do {

         choice =cinemaView.displayMenuList();
        switch (choice) {
            case AppConstant.ADD_CINEMA:
                ScreenView screenView = new ScreenView();
                cinemaManager.addCinemaDetails();
                ScreenManager screenManager = new ScreenManager();
                row = screenView.takeRow();
                column = screenView.takeColumn();
                screenManager.screenData(cinemaManager.cinemaId(), row, column);
                ScreenLayoutManager screenLayoutManager = new ScreenLayoutManager();
                screenLayoutManager.generateNumber(row, column);
                screenLayoutManager.screenLayoutDisplayData(row, column);
                screenLayoutManager.seatNumberToBook();
                break;
            case AppConstant.VIEW_CINEMA:
                cinemaManager.cinemaDetails();
                break;

            case AppConstant.ADD_MOVIE:
                MovieManager movieManager=new MovieManager();
                movieManager.movieDetails();
                break;
            case AppConstant.BACK:
                break;
            case AppConstant.EXIT:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice...");

        }
        }while (choice!=6);
    }
//        public void screenChoiceList(int choice) throws DAOException {
//            switch(choice)
//            {
//            case AppConstant.ADD_SCREEN:
//                ScreenView screenView = new ScreenView();
//                ScreenManager screenManager = new ScreenManager();
//                row = screenView.takeRow();
//                column = screenView.takeColumn();
//                screenManager.screenData(cinemaManager.cinemaId(), row, column);
//                ScreenLayoutManager screenLayoutManager = new ScreenLayoutManager();
//                screenLayoutManager.generateNumber(row, column);
//                screenLayoutManager.screenLayoutDisplayData(row, column);
//                screenLayoutManager.seatNumberToBook();
//                break;
//                case AppConstant.ADD_MOVIE:
//                    MovieManager movieManager=new MovieManager();
//                    movieManager.movieDetails();
//                break;
//                case AppConstant.BACK:
//                break;
//            case AppConstant.EXIT:
//                break;
//            default:
//                System.out.println("Invalid choice...");
//
//        }

}

