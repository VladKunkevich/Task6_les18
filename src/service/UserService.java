package service;

import bean.Role;
import bean.User;
import service.exception.ServiceException;

public interface UserService {
    User logination(String login, String password) throws ServiceException;
    User registerUser(String login, String password) throws ServiceException;
    boolean changeUserRole(String login, Role newRole) throws ServiceException;
}
