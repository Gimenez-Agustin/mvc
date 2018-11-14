package view;

import java.util.Scanner;

public class MainView {

    public boolean exit;

    public MainView() {
        exit = false;
    }

    public void display() {
        while (!exit) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Which operation do you want to do?");
            System.out.println("----------------------------------");
            System.out.println("A) Manage Book");
            System.out.println("B) Manage Author");
            System.out.println("Q) Quit");
            String option = scan.nextLine().toUpperCase();
            switch (option) {
                case "A":
                    BookView bookView = new BookView();
                    bookView.display();
                    break;
                case "B":
                    AuthorView authorView = new AuthorView();
                    authorView.display();
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
