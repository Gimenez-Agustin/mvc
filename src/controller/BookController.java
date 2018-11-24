package controller;

import model.Author;
import model.Book;
import mvc.MVC;

public class BookController {
    
    
    public static String addBook(Book book) throws Exception{
        try {
            MVC.books.add(book);
            return "Done!";
        } catch (Exception ex) {
             throw new Exception(ex);
        }
    }
    
    public static String delteBook(Book book) throws Exception{
        try {
            for(Book bo: MVC.books){
                if(bo.getTitle().equals(book.getTitle()) && bo.getAuthor().equals(book.getAuthor())){
                    MVC.books.remove(bo);
                    return "done!";
                }
            }
            return "couldn't find the Book";
        } catch (Exception ex) {
             throw new Exception(ex);
        }
    }
    
    public static Book createBook(String title, String subtitle, Author author){
        Book book = new Book();
        book.setTitle(title);
        book.setSubTitle(subtitle);
        book.setAuthor(author);
        return book;
    }
    
    public static void displayBooks() {
        int ind = 1;
        System.out.println("   *** Books ***   ");
        for (Book book : MVC.books) {            
            System.out.println(ind + " "  + book.getTitle() + " " + book.getSubTitle());
            ind++;
        }
        System.out.println("   ***       ***   ");
    }
    
    public static Book getBookById(int id){
        return MVC.books.get(id);
    }
    
}
