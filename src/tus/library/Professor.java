package tus.library;

import java.util.List;

public class Professor extends User {
    public Professor(String uName, String email, int userId, List<Book> booksBorrowed, boolean isStudent) throws Exception {
        super(uName, email, "professor", userId, booksBorrowed, false);
    }

    public Professor(){}
    @Override
    public String donateToLibrary(){
        return "Professors Union " + "200 Euros";
    }
}
