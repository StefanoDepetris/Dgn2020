import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {
    String testInput = "Macarena\n" + // Nombre
            "39486234\n" + // DNI
            "29448367"; // Telefono
    Scanner mockScanner = new Scanner(testInput);
    Paciente p = new Paciente(mockScanner);

    @Test
    public void getNombre() {

        assertEquals("Macarena",p.getNombre());
    }
    @Test
    public void getDNI() {

        assertEquals(39486234,p.getDNI());
    }
    @Test
    public void getTelefono() {

        assertEquals(29448367,p.getTelefono());
    }

}