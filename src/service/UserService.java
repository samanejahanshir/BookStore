package service;

import dao.BookDao;
import model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return bookList.stream().collect(Collectors.groupingBy(i -> i.getAuthorName()));
    }

    public Map<String, List<Book>> sortBookByYear(Map<String, List<Book>> mapBook) {
       /* mapBook.forEach((i,j)->{
            j=mapBook.get(i);
           j= j.stream().sorted((a,b)->Integer.compare(Integer.parseInt(b.getYear()),Integer.parseInt(a.getYear()))).collect(Collectors.toList());
        });
        return mapBook;*/
        List<Book> books=new ArrayList<>();
        Map<String, List<Book>> mapBookSorted =new HashMap<>();
        //Function<String,List<Book>> function=(i)->mapBook.get(i);
        for (Map.Entry<String, List<Book>> stringListEntry : mapBook.entrySet()) {
            books = stringListEntry.getValue();
            books.sort((a, b) -> b.getYear().compareTo(a.getYear()));
            mapBookSorted.put(stringListEntry.getKey(), books);

        }

        return mapBookSorted;
    }

}
