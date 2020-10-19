package service;

import service.impl.UpdateLibraryServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UpdateLibraryService updateLibraryService = new UpdateLibraryServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UpdateLibraryService getUpdateLibraryService(){
        return updateLibraryService;
    }

    public UserService getUserService(){
        return userService;
    }
}
