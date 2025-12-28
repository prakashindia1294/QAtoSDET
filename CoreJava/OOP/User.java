package OOP;

import java.util.Scanner;

/**
 * This Class has static nested class and non-static nested class
 * Class Builder is non-static nested class
 * Class Validator is a static nested class
 */
public final class User { //Top lever class or outer class
    private String username;
    private String email;
    private String role;

    /*
        * Tightly coupled helper classes that require access to the outer class’s instance variables/methods.
        * Event handling in GUI frameworks (e.g., Swing, JavaFX).
        * Encapsulation: Hide complex logic inside the outer class while still accessing its state.
        * Iterator implementations inside collection classes.
     */

    // Non-Static Nested Classes or Inner class
    // Implemented Builder class for creating user object in a clean way.

    public static class Builder {
        private String username;
        private String email;
        private String role;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role){
            this.role = role;
            return this;
        }

        public User build() {
            User user = new User();
            user.username = this.username;
            user.email = this.email;
            user.role = this.role;
            return user;
        }
    }

    /*
        Application of static nested class
        * Helper/Utility classes that logically belong to the outer class but don’t need access to its instance data.
        * Encapsulation: Hide implementation details from outside code.
        * Memory efficiency: Since it doesn’t hold a reference to the outer class instance, it avoids unnecessary memory usage.
        * Grouping constants or enums inside a related class.
     */

    // Static nested class for validation
    public static class Validator {
        private static final int MAX_USERNAME_LENGTH = 25;
        private static final String DEFAULT_ROLE = "GUEST";

        public static boolean isValidEmail(String email) {
            return email != null && email.contains("@");
        }
        public static boolean isUserNameValid(String user) {
            return user != null && user.length() <= MAX_USERNAME_LENGTH;
        }
        public static String isRoleValid(String role) {
            return (role == null) ? DEFAULT_ROLE : role;
        }

        public static boolean validate(User user){
            user.role = user.role == null ? DEFAULT_ROLE : user.role;
            return isUserNameValid(user.username) && isValidEmail(user.email);
        }
    }

    public static void main(String[] args){
        String testEmail = "prakash@example.com";
        String userName = "Prakash";
        String role = null;
        User user = new User.Builder()
                .setUsername(userName)
                .setEmail(testEmail)
                .setRole(role)
                .build();
        System.out.println("Is Valid User: " + User.Validator.validate(user));
        System.out.println("User Name: "+ user.username);
        System.out.println("Role: " + user.role);
        System.out.println("Email: " + user.email);
    }
}

