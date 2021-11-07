package view;

import exeptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
   static Scanner scanner=new Scanner(System.in);
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
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());

            }
        }

    }
    public static void showListBook(){

    }
}
