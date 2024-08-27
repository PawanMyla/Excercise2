import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> students;

    public StudentServiceImpl() {
        students = new ArrayList<>();
        students.add(new Student("John", 20, "S01"));
        students.add(new Student("Alice", 22, "S02"));
        students.add(new Student("Bob", 19, "S03"));
    }

    @Override
    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null; // Return null if not found
    }
}
