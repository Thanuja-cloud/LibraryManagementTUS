package tus.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Catalogue ct;
    static List<Book> bookList1 = new ArrayList<>();

    List<Book> bookList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
       Book b1 = new Book("python basics", "cormac", 123, "CSE", true);
       Book b2 = new Book("java basics", "cormac", 456, "CSE", false);
       Book b3 = new Book("devops basics", "cormac", 789, "CSE", true);
       addBooks(b1, b2, b3);
       printAllAvailableBooks();

       String msg = "Most Popular Books Are: "; // Effectively final
       // Immutable Class
        MostPopularBooks popularBooks = new MostPopularBooks(bookList1);
        popularBooks.getPopularBooks().stream().forEach(bk ->{
            System.out.println(msg + bk.toString());
        });
        // checked exception
        try {
            User use = new Student("A001234", "abc123@gmail.com", "student", 123, null, true);
            boolean status =  use.validateIdCard("C:\\Users\\Thanuja\\Downloads\\idcard.txt");
            if(status){
                System.out.println("Valid user");
            }
            else{
                System.out.println("Invalid user");
            }
            // LVTI
            var message = use.donateToLibrary();
            System.out.println(message);//why are we printing donateToLibrary
            printFamousAuthors();
        }
        catch (Exception ex){
            System.out.println("Failed to create user: "+ ex.getMessage());
        }
    }

    // Lambda expressions & Method Overloading
    // Here department and book id are effectively final
    public static List<Book> getBooks(String bookDepartment){
        return ct.getCollection().stream() //what is .stream???
                // bookDepartment = Book.BookDepartment.ECE; - We cannot reassign
                .filter(book -> Book.BookDepartment.CSE.toString().equalsIgnoreCase(bookDepartment))
                .collect(Collectors.toList());
    }
    public static List<Book> getBooks(int bookId){
        return ct.getCollection().stream()
                .filter(book -> bookId == book.getBookId())
                .collect(Collectors.toList()); //what is this collectors
    }
    // Varargs
    public static void addBooks(Book... books){
        bookList1.addAll(Arrays.asList(books));
        ct = new Catalogue(bookList1);
    }
    // Method Reference while using isAvailable and print new line
    public static void printAllAvailableBooks(){
        System.out.println("Available Books: ");
        ct.getCollection().stream().filter(Book::isAvailable).forEach(System.out::println);
        System.out.println(" ------------------------------  ");
    }

    // Use of arrays and string builder
    public static void printFamousAuthors(){
        StringBuilder sb = new StringBuilder();
        sb.append("Jane-Austen ");
        sb.append("William-Shakespeare ");
        sb.append("Mark-Twain ");
        sb.append("Leo-Tolstoy ");
        sb.append("J.K.Rowling ");
        String [] authors = sb.toString().split(" ");
        System.out.println("Famous Authors: ");
        for(int p=0; p<authors.length; p++){
            System.out.println(authors[p]);
        }

    }
}