package HospitalManagementSystem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements Readable<Patient>, Writeable<Patient> {
    private DatabaseConnection db;

    public PatientRepository(DatabaseConnection db) { this.db = db; }

    @Override
    public boolean add(Patient patient) {
        String query = "INSERT INTO patients(name, age, gender) VALUES(?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                patients.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("gender")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return patients;
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT id FROM patients WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { return false; }
    }
}