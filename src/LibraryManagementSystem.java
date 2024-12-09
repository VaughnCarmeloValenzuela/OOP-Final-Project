import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryManagementSystem {
    private List<LibraryItem> items;
    private List<Member> members;
    private Member currentMember;
    private Scanner scanner;
    private int nextMembershipId = 101;

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }

    public LibraryManagementSystem() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeLibrary();
    }

    private void initializeLibrary() {
        items.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", "Main"));
        items.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", "Central"));
        items.add(new Book("To Kill a Mockingbird", "Harper Lee", "Historical Fiction", "Main"));
    }

    public void run() {
        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            processUserChoice(choice);
        }
    }

    private void displayMainMenu() {
        System.out.println("\n--- BOOK LOOT ---");
        System.out.println("1. Register Member");
        System.out.println("2. Login");
        System.out.println("3. Search Books");
        System.out.println("4. View All Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                registerMember();
                break;
            case 2:
                loginMember();
                break;
            case 3:
                searchBooks();
                break;
            case 4:
                viewAllBooks();
                break;
            case 5:
                System.out.println("Thank you for using the Library Management System. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void registerMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter preferred branch (Main/Central): ");
        String branch = scanner.nextLine();

        if (branch.isEmpty()) branch = "Main";

        Member newMember = new Member(name, nextMembershipId++, branch);
        members.add(newMember);

        System.out.println("Member registered successfully!");
        System.out.println("Your Membership ID is: " + newMember.getMembershipId());
    }

    private void loginMember() {
        System.out.print("Enter your Membership ID: ");
        int membershipId = scanner.nextInt();
        scanner.nextLine();

        currentMember = findMember(membershipId);

        if (currentMember != null) {
            memberMenu();
        } else {
            System.out.println("Member not found.");
        }
    }

    private void memberMenu() {
        while (true) {
            System.out.println("\n--- Welcome " + currentMember.getName() + " ---");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Profile");
            System.out.println("4. Search Books");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    currentMember.displayProfile();
                    break;
                case 4:
                    searchBooks();
                    break;
                case 5:
                    currentMember = null;
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void borrowBook() {
        if (currentMember == null) {
            System.out.println("Please login first.");
            return;
        }

        List<LibraryItem> availableBooks = getAvailableItems();

        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Available Books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i).getTitle());
        }

        System.out.print("Enter the number of the book you want to borrow: ");
        int bookChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (bookChoice >= 0 && bookChoice < availableBooks.size()) {
            LibraryItem selectedBook = availableBooks.get(bookChoice);
            selectedBook.markBorrowed();
            currentMember.addBorrowedItem(selectedBook);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    private void returnBook() {
        if (currentMember == null) {
            System.out.println("Please login first.");
            return;
        }

        List<LibraryItem> borrowedBooks = currentMember.getBorrowedItems();

        if (borrowedBooks.isEmpty()) {
            System.out.println("You have no books to return.");
            return;
        }

        System.out.println("Your Borrowed Books:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).getTitle());
        }

        System.out.print("Enter the number of the book you want to return: ");
        int bookChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (bookChoice >= 0 && bookChoice < borrowedBooks.size()) {
            LibraryItem bookToReturn = borrowedBooks.get(bookChoice);
            bookToReturn.returnItem();
            currentMember.removeBorrowedItem(bookToReturn);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    private void searchBooks() {
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();

        List<LibraryItem> searchResults = items.stream()
                .filter(item ->
                        item.getTitle().toLowerCase().contains(searchTerm) ||
                                item.getAuthor().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());

        if (searchResults.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Search Results:");
            searchResults.forEach(LibraryItem::displayDetails);
        }
    }

    private void viewAllBooks() {
        System.out.println("All Books in Library:");
        items.forEach(LibraryItem::displayDetails);
    }

    private Member findMember(int membershipId) {
        return members.stream()
                .filter(member -> member.getMembershipId() == membershipId)
                .findFirst()
                .orElse(null);
    }

    private List<LibraryItem> getAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .collect(Collectors.toList());
    }
}