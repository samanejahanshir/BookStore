package view;

import exeptions.InvalidInputException;
import model.Book;
import service.UserService;

import java.sql.SQLException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserService userService;

    static {
        try {
            userService = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("---------- Welcome To Store ----------");
        outer:
        while (true) {
            System.out.println("1.Show Books information\n2.exit");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        showListBook();
                        break;
                    case 2:
                        System.out.println("---| GoodBye |---");
                        break outer;
                    default:
                        throw new InvalidInputException("Please Enter 1 or 2 !");
                }
            } catch (InputMismatchException | SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());

            }
        }

    }

    public static void showListBook() throws SQLException, ClassNotFoundException {
        Map<String, List<Book>> mapBooks = userService.showListBooks();
        // mapBooks.forEach((i, j) -> System.out.println(i + " " + j));
        System.out.format("+----------------------+-------------+-----------+---------------+------------+----------+------------------+%n");
        System.out.format("|     Author Name      |     ISBN    |   Title   | PublisherYear |    Price   | SoldNum  | Sold Total Price |%n");
        System.out.format("+----------------------+-------------+-----------+---------------+------------+----------+------------------+%n");
        String leftAlignFormat = "| %-20s | %-11s | %-9s | %-13s | %-10d | %-8d | %-16d |%n";
        List<Book> books = new ArrayList<>();
        int length = 0;
        for (Map.Entry<String, List<Book>> stringListEntry : mapBooks.entrySet()) {
            books = stringListEntry.getValue();
            String author = books.get(0).getAuthorName();
            length++;
            for (int i = 0; i < books.size(); i++) {

                System.out.format(leftAlignFormat, author, books.get(i).getIsbn(), books.get(i).getTitle(), books.get(i).getYear(), books.get(i).getPrice()
                        , books.get(i).getSoldNumber(), books.get(i).getTotalSoldPrice());

                author = "";
                if (i < books.size() - 1) {
                    if (books.get(i).getAuthorName().equalsIgnoreCase(books.get(i + 1).getAuthorName())) {
                        System.out.format("|                      |------------------------------------------------------------------------------------|%n");
                    }
                    if (!books.get(i).getAuthorName().equalsIgnoreCase(books.get(i + 1).getAuthorName())) {
                        author = books.get(i + 1).getAuthorName();


                    }
                }
            }
            if (length!=mapBooks.size())
                System.out.format("|-----------------------------------------------------------------------------------------------------------|%n");

        }
        System.out.format("+----------------------+-------------+-----------+---------------+------------+----------+------------------+%n");
    }
}
