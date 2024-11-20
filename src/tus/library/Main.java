package tus.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Catalogue ct;


    List<Book> bookList = new ArrayList<>();
    public static void main(String[] args) {
       /*Book b1 = new Book("python basics", "cormac", 123, "CSE", true);
       Book b2 = new Book("java basics", "cormac", 456, "CSE", false);
       Book b3 = new Book("devops basics", "cormac", 789, "CSE", true);

       List<Book> bookList1 = new ArrayList<>();
       bookList1.add(b1);
       bookList1.add(b2);
       ct = new Catalogue(bookList1);
       bookList1.add(b3);
       // Call by value when calling get books
       for(Book b: getBooks(String.valueOf(Book.BookDepartment.CSE), true)){
           System.out.println(b.getBookName() + " - " + b.getAuthor());
        }*/
        try {
            User use = new Student("A001234", "abc@gmail.com", 123, null, true);
            System.out.println(use.donateToLibrary());
        }
        catch (Exception ex){
            System.out.println("Failed to create user: "+ ex.getMessage());
        }
    }

    // Lambda expressions
    public static List<Book> getBooks(String bookDepartment){
        return ct.getCollection().stream()
                .filter(book -> book.getBookDepartment().contains(Book.BookDepartment.CSE.toString()))
                .collect(Collectors.toList());
    }
    public static List<Book> getBooks(String bookDepartment, boolean isAvailable){
        return ct.getCollection().stream()
                .filter(book -> book.getAuthor().contains("cormac") && book.isAvailable())
                .collect(Collectors.toList());
    }
}