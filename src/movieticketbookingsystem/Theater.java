package movieticketbookingsystem;
import java.util.List;
import java.util.Map;

public class Theater {
    private String Location;
    private int SeatingCapacity;
    private DatabaseOperation db = new DatabaseOperation();    
                                                                                         // Method to insert theater into database
    public void insertTheater(String Location, int SeatingCapacity) {
        String sql = "INSERT INTO Theaters(Location, SeatingCapacity) VALUES (?, ?)";
        Object[] values = {Location, SeatingCapacity};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0)
            System.out.println("Theater inserted successfully");
        else
            System.out.println("Something went wrong. Theater not inserted.");
    }                                                                                                     // Method to view all theaters in database
    public void showTheaters() {
        String sql = "SELECT * FROM Theaters";
        List<Map<String, Object>> theaters = db.getRecords(sql);
        for (Map<String, Object> theater : theaters) {
            System.out.println("Theater ID: " + theater.get("TheaterID"));
            System.out.println("Location: " + theater.get("Location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------------");
        }
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public int getSeatingCapacity() {
        return SeatingCapacity;
    }
    public void setSeatingCapacity(int seatingCapacity) {
        SeatingCapacity = seatingCapacity;
  }
}
