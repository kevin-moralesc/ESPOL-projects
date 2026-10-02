package HospitalManagementSystem;
import java.sql.Connection;

public interface AvailabilityRule {
    boolean isAvailable(int doctorId, String date, DatabaseConnection db);
}