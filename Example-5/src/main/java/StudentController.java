import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{name}")
    public String getStudentDetails(@PathVariable String name) {
        Student student = studentService.getStudentByName(name);
        if (student != null) {
            return "Name: " + student.getName() + ", Age: " + student.getAge() + ", ID: " + student.getId();
        } else {
            return "Student details not found.";
        }
    }
}
