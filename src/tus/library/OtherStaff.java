package tus.library;

import tus.library.Interfaces.Transaction;

import java.time.LocalDate;
import java.util.List;

public non-sealed class OtherStaff extends User implements Transaction {
    public OtherStaff(String uName, String email, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        super(uName, email, "otherstaff", userId, booksBorrowed, false);
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
