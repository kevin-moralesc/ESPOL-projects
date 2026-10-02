package HospitalManagementSystem;
import java.util.List;

public class DoctorView {
    private Readable<Doctor> reader;

    public DoctorView(Readable<Doctor> reader) {
        this.reader = reader;
    }

    public void displayDoctors() {
        List<Doctor> doctors = reader.getAll();
        System.out.println("Doctors: ");
        System.out.println("+------------+--------------------+------------------+");
        System.out.println("| Doctor Id  | Name               | Specialization   |");
        System.out.println("+------------+--------------------+------------------+");
        for (Doctor d : doctors) {
            System.out.printf("| %-10s | %-18s | %-16s |\n", d.getId(), d.getName(), d.getSpecialization());
            System.out.println("+------------+--------------------+------------------+");
        }
    }
}