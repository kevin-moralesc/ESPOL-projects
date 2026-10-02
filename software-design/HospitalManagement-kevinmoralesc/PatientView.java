package HospitalManagementSystem;
import java.util.List;
import java.util.Scanner;

public class PatientView {
    private Scanner scanner;
    private Writeable<Patient> writer;
    private Readable<Patient> reader;

    public PatientView(Scanner scanner, Writeable<Patient> writer, Readable<Patient> reader) {
        this.scanner = scanner;
        this.writer = writer;
        this.reader = reader;
    }

    public void promptAddPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();

        Patient newPatient = new Patient(0, name, age, gender); // ID es 0 porque la BD lo autogenera
        if (writer.add(newPatient)) {
            System.out.println("Patient Added Successfully!!");
        } else {
            System.out.println("Failed to add Patient!!");
        }
    }

    public void displayPatients() {
        List<Patient> patients = reader.getAll();
        System.out.println("Patients: ");
        System.out.println("+------------+--------------------+----------+------------+");
        System.out.println("| Patient Id | Name               | Age      | Gender     |");
        System.out.println("+------------+--------------------+----------+------------+");
        for (Patient p : patients) {
            System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", p.getId(), p.getName(), p.getAge(), p.getGender());
            System.out.println("+------------+--------------------+----------+------------+");
        }
    }
}