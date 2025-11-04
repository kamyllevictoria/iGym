import com.igym.igym.model.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        student.generateRegistrationNumber();

        System.out.println("Matrícula gerada: " + student.getRegistrationNumber());
    }
}

