package javaa.users;

public class RegularUser extends User {

    // Constructor for java.RegularUser
    public RegularUser(String username) {
        super(username);
        // Additional initialization specific to java.RegularUser
    }

    // Override the viewPortfolio method
    @Override
    public void viewPortfolio() {
        super.viewPortfolio();
        // Additional implementation specific to java.RegularUser, if any
    }

    // Example of a method specific to java.RegularUser
    public void viewWatchlist() {
        // Implementation for viewing watchlist
    }

    // Other methods and fields specific to java.RegularUser
}
