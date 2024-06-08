package movieticketbookingsystem;
import java.util.Scanner;
public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Admin admin = new Admin();
            Login login = new Login();
            while (true) {
                System.out.println("Welcome to Movie Ticket Booking System");
                System.out.println("Press 1 for Admin login");
                System.out.println("Press 2 for User login");
                System.out.println("Press 3 to Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                                                                                                      //optional claas
                switch (choice) {
                    case 1:
                        admin.adminMenu();
                        break;
                    case 2:
                        login.validate();
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
 }
}
 // this class can be used as the optional // if the MovieTickedDriver class had any problem while login or signup