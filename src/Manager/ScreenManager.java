package Manager;

import common.Session;
import dao.ScreenDao;
import exception.DAOException;
import model.Cinema;
import model.Screen;

public class ScreenManager {
    private ScreenDao screenDao = new ScreenDao();

    //
//    public void displayMenuDetails() throws DAOException {
//        Operations operations=new Operations();
//       int choice = screenView.screenMenuList();
//        operations.screenChoiceList(choice);
//    }
    public void screenData(Cinema cinema, int row, int column) throws DAOException {
        screenDao.addScreenData(cinema.getId(), row, column);
    }

    public int screenDetails() throws DAOException {
        Screen screen = screenDao.getScreenData();
        return screen.getScreenId();
    }
}
