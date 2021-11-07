package view;

import exeptions.InvalidInputException;
import model.Book;
import service.UserService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
   static Scanner scanner=new Scanner(System.in);
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
                switch (scanner.nextInt()){
                    case 1:
                        showListBook();
                        break ;
                    case 2:
                        System.out.println("---| GoodBye |---");
                        break outer;
                    default:
                        throw  new InvalidInputException("Please Enter 1 or 2 !");
                }
            }catch (InputMismatchException | SQLException | ClassNotFoundException e){
                System.out.println(e.getMessage());

            }
        }

    }
    public static void showListBook() throws SQLException, ClassNotFoundException {
        Map<String, List<Book>> books = userService.showListBooks();
books.forEach((i,j)-> System.out.println(i+" "+ j));    }
}
