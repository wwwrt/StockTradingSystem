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

//Factory Pattern pentru crearea utilizatorilor
//Motivație: deoarece Factory simplifică procesul de creare a utilizatorilor, și aveam nevoie de o metodă centralizată și flexibilă pentru instanțiere.
// Utilizând pattern-ul Factory, poț adăuga ușor noi tipuri de utilizatori fără a modifica codul existent, și astfel promovând
// principiul deschis/închis al OOP =)).