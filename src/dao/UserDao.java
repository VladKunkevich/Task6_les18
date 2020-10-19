package dao;

import bean.Role;
import bean.User;
import dao.exception.DAOException;

public interface UserDao {
    public User registerUser(String login, String password) throws DAOException;
    public User logination(String login, String password) throws DAOException;
    public boolean changeUserRole(String login, Role newRole) throws DAOException;
}
