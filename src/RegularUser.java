public class RegularUser extends User {

    // Constructor for RegularUser
    public RegularUser(String username) {
        super(username);
        // Additional initialization specific to RegularUser
    }

    // Override the viewPortfolio method
    @Override
    public void viewPortfolio() {
        super.viewPortfolio();
        // Additional implementation specific to RegularUser, if any
    }

    // Example of a method specific to RegularUser
    public void viewWatchlist() {
        // Implementation for viewing watchlist
    }

    // Other methods and fields specific to RegularUser
}
