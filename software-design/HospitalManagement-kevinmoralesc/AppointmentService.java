package HospitalManagementSystem;
import java.sql.*;

public class AppointmentService {
    private DatabaseConnection db;
    private Readable<Patient> patientRepo;
    private Readable<Doctor> doctorRepo;
    private AvailabilityRule availabilityRule;

    public AppointmentService(DatabaseConnection db, Readable<Patient> patientRepo, Readable<Doctor> doctorRepo, AvailabilityRule rule) {
        this.db = db;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.availabilityRule = rule;
    }

    public void bookAppointment(int patientId, int doctorId, String date) {
        if (!patientRepo.exists(patientId) || !doctorRepo.exists(doctorId)) {
            System.out.println("Either doctor or patient doesn't exist!!!");
            return;
        }

        if (!availabilityRule.isAvailable(doctorId, date, db)) {
            System.out.println("Doctor not available on this date!!");
            return;
        }

        String query = "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES(?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);
            if (ps.executeUpdate() > 0) {
                System.out.println("Appointment Booked!");
            } else {
                System.out.println("Failed to Book Appointment!");
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}