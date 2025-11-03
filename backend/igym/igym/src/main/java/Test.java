import com.igym.igym.model.Aluno;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        Aluno student = new Aluno();

        student.generateRegistrationNumber();

        System.out.println("Matrícula gerada: " + student.getRegistrationNumber());
    }
}

