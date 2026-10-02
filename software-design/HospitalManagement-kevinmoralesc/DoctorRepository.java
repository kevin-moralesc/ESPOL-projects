package HospitalManagementSystem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository implements Readable<Doctor> {
    private DatabaseConnection db;

    public DoctorRepository(DatabaseConnection db) { this.db = db; }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                doctors.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("specialization")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return doctors;
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT id FROM doctors WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { return false; }
    }
}