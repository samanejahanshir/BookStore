package service;

import dao.BookDao;
import model.Book;

import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {
    BookDao bookDao = new BookDao();

    public UserService() throws SQLException, ClassNotFoundException {
    }

    public Map<String, List<Book>> showListBooks() throws SQLException, ClassNotFoundException {
        List<Book> bookList = new ArrayList<>();
        bookList = bookDao.getAll();
        for (Book book : bookList) {
            book.setTotalSoldPrice(book.calculateTotalSoldPrice());
        }
        Map<String, List<Book>> mapBooks = listBookByAuthor(bookList);
        return sortBookByYear(mapBooks);


    }

    public Map<String, List<Book>> listBookByAuthor(List<Book> bookList) {
       // Map<String, List<Book>> map = bookList.stream().collect(Collectors.groupingBy(i -> i.getAuthorName()));


          return bookList.stream().collect(Collectors.groupingBy(i -> i.getAuthorName()));

    }

    public Map<String, List<Book>> sortBookByYear(Map<String, List<Book>> mapBook) {

        List<Book> books = new ArrayList<>();
        Map<String, List<Book>> mapBookSorted = new HashMap<>();
        for (Map.Entry<String, List<Book>> stringListEntry : mapBook.entrySet()) {
            books = stringListEntry.getValue();
            books.sort((a, b) -> b.getYear().compareTo(a.getYear()));
            mapBookSorted.put(stringListEntry.getKey(), books);

        }

        return mapBookSorted.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

}
