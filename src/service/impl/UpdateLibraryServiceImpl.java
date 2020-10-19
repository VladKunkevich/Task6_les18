package service.impl;

import bean.Book;
import bean.Role;
import dao.DAOFactory;
import dao.exception.DAOException;
import service.UpdateLibraryService;
import service.exception.ServiceException;

import java.util.List;

public class UpdateLibraryServiceImpl implements UpdateLibraryService {
    @Override
    public void addNewBook(String title, int price, Role access) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();

        try {
            daoFactory.getBookDAO().add(new Book(title, price, access));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> showLibrary(Role access) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Book> books;

        try {
            books = daoFactory.getBookDAO().allLibrary(access);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return books;
    }
}
