package tus.library;

import tus.library.Interfaces.Payment;
import tus.library.Interfaces.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public non-sealed class Student extends User implements Transaction {
    public Student(String uName, String email, String role, int userId,  List<Book> booksBorrowed, boolean isStudent) throws Exception {
        super(uName, email, "student", userId, booksBorrowed, true);
        // Super
        System.out.println("Fine amount: " + super.fineAmount);
        System.out.println("Max books you can borrow: " + super.maxBooksToBorrow);
        System.out.println("Max time you can borrow: " + super.maxTime);
    }
    // Used this() here
    public Student() throws Exception {
        this("Default", "abc@gmail.com", "student", 234, new ArrayList<>(), true);
    }

    @Override
    public String donateToLibrary(){
        return "Student Welfare Donation " + "100 Euros";
    }


    @Override
    public void borrowBook(Book book) {
        book.setBorrowDate(LocalDate.now());
        if(this.booksBorrowed.size() < super.maxBooksToBorrow){
            this.booksBorrowed.add(book);
        }
        else{
            System.out.println("Max Book already borrowed!");
        }
    }

    @Override
    public void returnBook(Book book) {
        book.setReturnDate(LocalDate.now());
        book.finePayment(this); // To check if any fines for books returned
        this.booksBorrowed.remove(book);
    }
}
