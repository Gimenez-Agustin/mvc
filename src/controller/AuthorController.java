package controller;

import model.Author;
import mvc.MVC;

public class AuthorController {

    public static String addAuthor(Author author) throws Exception {
        try {
            MVC.authors.add(author);
            return "Done!";
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static String delteAuthor(Author author) throws Exception {
        try {
            for (Author au : MVC.authors) {
                if (au.getName().equals(author.getName()) && au.getSurname().equals(author.getSurname())) {
                    MVC.authors.remove(au);
                    return "Done!";
                }
            }
            return "Couldn't find Author";
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static Author createAuthor(String name, String Surname) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(Surname);
        return author;
    }

    public static void displayAuthors() {
        int ind = 1;
        System.out.println("   *** Authors ***   ");
        for (Author author : MVC.authors) {            
            System.out.println(ind + " " + author.getName() + " " + author.getSurname());
            ind++;
        }
        System.out.println("   ***         ***   ");
    }
    
    public static Author getAuthorById(int id){
        return MVC.authors.get(id);
    }

}
