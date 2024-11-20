package tus.library;

import tus.library.Interfaces.Payment;

import java.util.List;

public class Student extends User {
    public Student(String uName, String email, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        super(uName, email, "student", userId, booksBorrowed, true);
    }
    public Student(){}



    @Override
    public String donateToLibrary(){
        return "Student Welfare Donation " + "100 Euros";
    }


}
