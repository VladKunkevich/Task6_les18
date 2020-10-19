package service;

import bean.Book;
import bean.Role;
import service.exception.ServiceException;

import java.util.List;

public interface UpdateLibraryService {
    void addNewBook(String title, int price, Role access) throws ServiceException;
    List<Book> showLibrary(Role access) throws ServiceException;
}
