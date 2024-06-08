package movieticketbookingsystem;
import java.sql.Timestamp;
import java.util.Scanner;
public class Admin
{
    private Scanner sc = new Scanner(System.in);
    private Movie movie = new Movie();
    private Theater theater = new Theater();
    private Showtime showtime = new Showtime();
    public void adminMenu() {
        int choice;
        while (true)
        {
            System.out.println("---------- Admin Menu ----------");
            System.out.println("Press 1 to add a movie.");
            System.out.println("Press 2 to add a theater.");
            System.out.println("Press 3 to add a showtime.");
            System.out.println("Press 4 to see all movies.");
            System.out.println("Press 5 to see all theaters.");
            System.out.println("Press 6 to see all showtimes.");
            System.out.println("Press 7 to exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    addMovie();
                    break;
                case 2:
                    addTheater();
                    break;
                case 3:
                    addShowtime();
                    break;
                case 4:
                    movie.showMovies();
                    break;
                case 5:
                    theater.showTheaters();
                    break;
                case 6:
                    showtime.showShowtimes();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
       }
        }
    }
    private void addMovie() 
    {
        sc.nextLine(); 
        System.out.println("Enter movie title: ");
        String title = sc.nextLine();
        System.out.println("Enter movie genre: ");
        String genre = sc.nextLine();
        System.out.println("Enter movie rating: ");
        double rating = sc.nextDouble();
        System.out.println("Enter movie duration (in minutes): ");
        int duration = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter movie synopsis: ");
        String synopsis = sc.nextLine();
        movie.insertMovie(title, genre, rating, duration, synopsis);
   }
    private void addTheater() {
        sc.nextLine(); 
        System.out.println("Enter theater location: ");
        String location = sc.nextLine();
        System.out.println("Enter seating capacity: ");               //adding the new thearer only of admin
        int seatingCapacity = sc.nextInt();
        theater.insertTheater(location, seatingCapacity);
   }
   private void addShowtime() {
       System.out.println("Enter movie ID: ");
        int movieID = sc.nextInt();
        System.out.println("Enter theater ID: ");
        int theaterID = sc.nextInt();
        System.out.println("Enter showtime (YYYY-MM-DD HH:MM:SS): ");                 //addin the showtime only for admin
        sc.nextLine(); 
        String showtimeStr = sc.nextLine();
        Timestamp showtime = Timestamp.valueOf(showtimeStr);
        this.showtime.insertShowtime(movieID, theaterID, showtime);
 }
}
