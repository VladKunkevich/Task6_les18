package command.impl;

import bean.Book;
import bean.Role;
import command.Command;
import command.exception.CommandException;
import service.ServiceFactory;
import service.exception.ServiceException;

import java.util.List;

public class ShowLibrary implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String[] params = request.split("\\s+");
        Role access = Role.JUNIOR;
        List<Book> books;

        try {
            access = Role.valueOf(params[0]);

            books = ServiceFactory.getInstance().getUpdateLibraryService().showLibrary(access);

        } catch (IllegalArgumentException e) {
            throw new CommandException("UnrecognizableRole", e);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        StringBuilder response = new StringBuilder();
        for (Book book: books) {
            response.append(book.getTitle() + "(" + book.getPrice() + " BYN) \n");
        }

        return params[0] + " " + response;
    }
}
