package movieticketbookingsystem;
import java.util.Scanner;
public class Login {
    DatabaseOperation db = new DatabaseOperation();
    Scanner sc = new Scanner(System.in);
    public void showMenu() {
        while (true) {
            System.out.println("Welcome to Movie Ticket Booking System");
            System.out.println("Press 1 to Login");
            System.out.println("Press 2 to Sign Up");
            System.out.println("Press 3 to Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("Thank you for using Movie Ticket Booking System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
  }
  }
  }
    public void login() {
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();

        String sql = "SELECT Password FROM users WHERE Username = ?";
        String storedPassword = db.validatePass(sql, username);

        if (storedPassword.equals(password)) {
            System.out.println("Login successful.");
            int userID = db.fetchUserID("SELECT UserID FROM users WHERE Username = ?", username);
            User user = new User();
            user.userMenu(userID);
        } else {
            System.out.println("Invalid credentials.");
     }
    }
    public void signup() {
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        System.out.println("Enter your address: ");
        String address = sc.next();
        System.out.println("Enter your phone number: ");
        String phone = sc.next();
        String sql = "INSERT INTO users (Username, Password, Name, Address, Phone) VALUES (?, ?, ?, ?, ?)";
        Object[] values = {username, password, name, address, phone};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0)
            System.out.println("User registered successfully");
        else
            System.out.println("Something went wrong. User not registered.");
                                                                                                                // After signup, allow the user to log in
        login();
   }
	public void validate() {
}
}
