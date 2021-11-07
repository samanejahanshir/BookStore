package dao;

import model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends  AccessDao{
    public BookDao() throws SQLException, ClassNotFoundException {
    }

    public List<Book> getAll() throws SQLException, ClassNotFoundException {
        if (getConnection() != null) {

            PreparedStatement statement = getConnection().prepareStatement("select * from book");
            ResultSet resultSet = statement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {

                String title = resultSet.getString("title");
                String isbn = resultSet.getString("ISBN");
                String publishYear = resultSet.getString("publish_year");
                long price = resultSet.getLong("price");
                int soldNumber = resultSet.getInt("sold_number");
                String authorName = resultSet.getString("author_name");
                Book book = new Book(title,isbn,publishYear,price,soldNumber,authorName);
                book.setId(resultSet.getInt("id"));
                books.add(book);
            }
            return books;
        }
        return null;
    }
}
