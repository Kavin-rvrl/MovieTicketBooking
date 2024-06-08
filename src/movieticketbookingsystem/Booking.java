package movieticketbookingsystem;
import java.util.ArrayList;
import java.util.Scanner;
public class Booking {
    Showtime s = new Showtime();
    DatabaseOperation db = new DatabaseOperation();
    Scanner sc = new Scanner(System.in);
    public void bookTicket(int userID) {
        System.out.println("Avaialbe showtimes:");
        s.showShowtimes();
        System.out.println("Enter your showtime choice: ");      
        int showtime_choice = sc.nextInt();
        int capacity = s.getTheaterCapacity(showtime_choice);
        ArrayList<Integer> bookedSeats = db.getBookedSeats(showtime_choice);
        System.out.println("---------- Available Seats ----------");
        for (int i = 1; i <= capacity; i++) {
            if (bookedSeats.contains(i)) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }
            if (i % 8 == 0) {
                System.out.println();
            }
        }
        System.out.println("Enter the seat of your choice: ");
        int seat_choice = sc.nextInt();

        String sql = "insert into bookings(userid,showtimeid,selectedseats,paymentstatus) values(?,?,?,1)";
        Object[] values = {userID, showtime_choice, seat_choice};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0)
            System.out.println("Booking completed successfully");
        else
            System.out.println("Something went wrong.Booking failed.");
    }
    public void seeTicket(int userID) {
        System.out.println("Tickets Booked at different showtimes:");
        db.getAllBookingsForUser(userID);
        System.out.print("Enter ShowtimeID to know information: ");
        int showtimeID_choice = sc.nextInt();
        s.showShowtimesDetails(showtimeID_choice);
    }
    public void cancelTicket(int userID) {
        System.out.println("Tickets Booked at different showtimes:");
        db.getAllBookingsForUser(userID);
        System.out.print("Enter BookingID to cancel Booking: ");
        int bookingID_choice = sc.nextInt();
        int rowsAffected = db.removeBooking(bookingID_choice);
        if (rowsAffected > 0)
            System.out.println("Booking cancelled successfully");
        else
            System.out.println("Something went wrong.Booking not cancelled.");
}
}
