package HospitalManagementSystem;

public class Doctor extends HospitalMember {
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
}