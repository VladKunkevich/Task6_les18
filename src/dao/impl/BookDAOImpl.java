package dao.impl;

import bean.Book;
import bean.Role;
import dao.BookDao;
import dao.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDao {
    private static final String BOOK_FILE_NAME = "books.txt";

    @Override
    public void add(Book book) throws DAOException {
        FileWriter out;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {

            out = new FileWriter(BOOK_FILE_NAME, true);
            bw = new BufferedWriter(out);
            pw = new PrintWriter(bw);
            pw.println(book.getTitle() + " " + book.getPrice() + " " + book.getAccess());

        } catch (IOException e) {
            throw new DAOException("IOError", e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    @Override
    public List<Book> allLibrary(Role access) throws DAOException {
        List<Book> books = new ArrayList<Book>();
        FileReader reader = null;
        BufferedReader br = null;

        try {
            reader = new FileReader(BOOK_FILE_NAME);

            br = new BufferedReader(reader);

            String line;
            line = br.readLine();

            String[] params;
            if (access.equals(Role.ADULT)) {
                while(line != null) {

                    params = line.split("\\s+");
                    String title = params[0];
                    int price = Integer.parseInt(params[1]);
                    books.add(new Book(title, price));


                    line = br.readLine();
                }
            } else {
                while(line != null) {

                    params = line.split("\\s+");
                    String title = params[0];
                    int price = Integer.parseInt(params[1]);
                    String bookAccess = params[2];

                    if (bookAccess.equals(Role.JUNIOR.toString())) {

                        books.add(new Book(title, price));
                    }

                    line = br.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException("FileNotFound", e);
        } catch (IOException e) {
            throw new DAOException("IOError", e);
        } catch (NumberFormatException e) {
            throw new DAOException("ParseIntError", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                throw new DAOException("IOClosingError", e1);
            }
        }

        return books;
    }
}
