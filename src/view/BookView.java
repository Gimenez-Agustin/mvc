package view;

import controller.AuthorController;
import controller.BookController;
import java.util.Scanner;

public class BookView {

    public boolean exit;

    public BookView() {
        exit = false;
    }

    public void display() {
        while (!exit) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("A) Add book");
            System.out.println("B) Delete book");
            System.out.println("C) Display books");
            System.out.println("Q) Quit");
            String option = scan.nextLine().toUpperCase();
            switch (option) {
                case "A":
                    System.out.println("Please type the title of the book");
                    String title = scan.nextLine();
                    System.out.println("Please type the subtitle of the book");
                    String subtitle = scan.nextLine();
                    System.out.println("Please select the author");
                    boolean checkAdd = false;
                    while (!checkAdd) {
                        try {
                            AuthorController.displayAuthors();
                            System.out.println("Please type index of the Author");
                            int id = scan.nextInt();
                            id--;
                            checkAdd = true;
                            System.out.println(BookController.addBook(BookController.createBook(title, subtitle,AuthorController.getAuthorById(id))));
                        } catch (Exception ex) {
                            System.out.println("Please type a correct number");
                        }
                    }
                    try {

                    } catch (Exception ex) {
                        System.out.println("There was an error: " + ex.getMessage());
                    }
                    break;
                case "B":
                    boolean checkDelete = false;
                    while (!checkDelete) {
                        try {
                            BookController.displayBooks();
                            System.out.println("Please type index of the Book to delete");
                            int ind = scan.nextInt();
                            ind--;
                            checkDelete = true;
                            System.out.println(BookController.delteBook(BookController.getBookById(ind)));
                        } catch (Exception ex) {
                            System.out.println("Please type a correct number");
                        }
                    }
                    break;
                case "C":
                    BookController.displayBooks();
                    break;
                case "Q":
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose a correct Option.");
            }
        }
    }
}
