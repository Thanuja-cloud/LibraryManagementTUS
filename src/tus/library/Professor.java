package tus.library;

import tus.library.Interfaces.Transaction;

import java.time.LocalDate;
import java.util.List;


public non-sealed class Professor extends User implements Transaction {
    public Professor(String uName, String email, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        super(uName, email, "professor", userId, booksBorrowed, false);
    }

    public Professor(){}
    @Override
    public String donateToLibrary(){
        return "Professors Union " + "200 Euros";
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
