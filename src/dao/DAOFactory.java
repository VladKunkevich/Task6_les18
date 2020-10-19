package dao;

import dao.impl.BookDAOImpl;
import dao.impl.UserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private UserDao userDAO = new UserDAOImpl();
    private BookDao bookDAO = new BookDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserDao getUserDAO(){
        return userDAO;
    }

    public BookDao getBookDAO(){
        return bookDAO;
    }
}
