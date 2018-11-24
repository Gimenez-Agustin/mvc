package view;

import controller.AuthorController;
import java.util.Scanner;

public class AuthorView {

    public boolean exit;

    public AuthorView() {
        exit = false;
    }

    public void display() {
        while (!exit) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("A) Add author");
            System.out.println("B) Delete author");
            System.out.println("C) Display authors");
            System.out.println("Q) Quit");
            String option = scan.nextLine().toUpperCase();
            switch (option) {
                case "A":
                    System.out.println("Please type the name of the author");
                    String name = scan.nextLine();
                    System.out.println("Please type the surname of the author");
                    String surname = scan.nextLine();
                    try {
                        System.out.println(AuthorController.addAuthor(AuthorController.createAuthor(name, surname)));
                    } catch (Exception ex) {
                        System.out.println("There was an error: " + ex.getMessage());
                    }
                    break;
                case "B":
                    boolean check = false;
                    while (!check) {
                        try{
                        AuthorController.displayAuthors();
                        System.out.println("Please type index of the Author to delete");
                        int id = scan.nextInt();
                        id--;
                        check = true;
                            System.out.println(AuthorController.delteAuthor(AuthorController.getAuthorById(id)));
                        }catch(Exception ex){
                            System.out.println("Please type a correct number");
                        }
                    }
                    break;
                case "C":
                    AuthorController.displayAuthors();
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
