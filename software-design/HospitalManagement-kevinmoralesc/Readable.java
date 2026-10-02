package HospitalManagementSystem;
import java.util.List;

public interface Readable<T> {
    List<T> getAll();
    boolean exists(int id);
}