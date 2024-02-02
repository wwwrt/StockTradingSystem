package javaa.users;

public class UserFactory {
    public User createUser(String type, String username) {
        if (type.equalsIgnoreCase("regular")) {
            return new RegularUser(username);
        } else if (type.equalsIgnoreCase("admin")) {
            return new AdminUser(username);
        }
        return null;
    }
}
