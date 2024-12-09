import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int membershipId;
    private List<LibraryItem> borrowedItems;
    private String branch;

    public Member(String name, int membershipId, String branch) {
        this.name = name;
        this.membershipId = membershipId;
        this.borrowedItems = new ArrayList<>();
        this.branch = branch;
    }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public boolean removeBorrowedItem(LibraryItem item) {
        return borrowedItems.remove(item);
    }

    public void displayProfile() {
        System.out.println("Name: " + name);
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Branch: " + branch);
        System.out.println("Borrowed Items:");
        borrowedItems.forEach(item -> System.out.println(" - " + item.getTitle()));
    }

    public String getName() { return name; }
    public int getMembershipId() { return membershipId; }
    public String getBranch() { return branch; }
    public List<LibraryItem> getBorrowedItems() { return new ArrayList<>(borrowedItems); }
}