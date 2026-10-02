package HospitalManagementSystem;

public abstract class HospitalMember {
    protected int id;
    protected String name;

    public HospitalMember(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}