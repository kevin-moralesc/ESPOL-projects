package HospitalManagementSystem;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Configuramos la BD (DIP)
        DatabaseConnection dbConnection = new MySQLConnection("jdbc:mysql://localhost:3306/hospital", "root", "Admin@123");
        
        // 2. Inicializamos Repositorios
        PatientRepository patientRepo = new PatientRepository(dbConnection);
        DoctorRepository doctorRepo = new DoctorRepository(dbConnection);
        
        // 3. Inicializamos Vistas
        PatientView patientView = new PatientView(scanner, patientRepo, patientRepo);
        DoctorView doctorView = new DoctorView(doctorRepo);
        
        // 4. Inicializamos Servicios con su Regla (OCP)
        AvailabilityRule rule = new SingleAppointmentRule();
        AppointmentService appointmentService = new AppointmentService(dbConnection, patientRepo, doctorRepo, rule);

        while (true) {
            System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    patientView.promptAddPatient();
                    break;
                case 2:
                    patientView.displayPatients();
                    break;
                case 3:
                    doctorView.displayDoctors();
                    break;
                case 4:
                    System.out.print("Enter Patient Id: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter Doctor Id: ");
                    int doctorId = scanner.nextInt();
                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    appointmentService.bookAppointment(patientId, doctorId, date);
                    break;
                case 5:
                    System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Enter valid choice!!!");
                    break;
            }
        }
    }
}