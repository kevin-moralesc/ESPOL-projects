package HospitalManagementSystem;
import java.sql.*;

public class SingleAppointmentRule implements AvailabilityRule {
    @Override
    public boolean isAvailable(int doctorId, String date, DatabaseConnection db) {
        String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, doctorId);
            ps.setString(2, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}