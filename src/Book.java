import java.util.ArrayList;
import java.util.List;

public class Book extends LibraryItem {
    private String genre;
    private List<Member> reservations;

    public Book(String title, String author, String genre, String branch) {
        super(title, author, branch);
        this.genre = genre;
        this.reservations = new ArrayList<>();
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + genre);
        System.out.println("Available: " + isAvailable());
        System.out.println("Branch: " + getBranch());
    }

    public void addReservation(Member member) {
        if (!isAvailable()) {
            reservations.add(member);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is available. No need to reserve.");
        }
    }

    public List<Member> getReservations() {
        return new ArrayList<>(reservations);
    }

    public String getGenre() {
        return genre;
    }
}
