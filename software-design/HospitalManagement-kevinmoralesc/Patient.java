package HospitalManagementSystem;

public class Patient extends HospitalMember {
    private int age;
    private String gender;

    public Patient(int id, String name, int age, String gender) {
        super(id, name);
        this.age = age;
        this.gender = gender;
    }

    public int getAge() { return age; }
    public String getGender() { return gender; }
}