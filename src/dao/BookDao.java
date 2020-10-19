package dao;

import bean.Book;
import bean.Role;
import dao.exception.DAOException;

import java.util.List;

public interface BookDao {
    public void add(Book book) throws DAOException;
    public List<Book> allLibrary(Role access) throws DAOException;
}
