import java.util.ArrayList;

public abstract class LibraryItem {
    private String title;
    private String author;
    private boolean available;
    private String branch;

    public LibraryItem(String title, String author, String branch) {
        this.title = title;
        this.author = author;
        this.available = true;
        this.branch = branch;
    }

    public abstract void displayDetails();

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public String getBranch() { return branch; }

    public void markBorrowed() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available for borrowing.");
        }
    }

    public void returnItem() {
        available = true;
        System.out.println(title + " has been returned.");
    }
}