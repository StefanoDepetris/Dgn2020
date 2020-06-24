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
    void pagarConsulta() { // LISTOO

        FormaDePago a = new Efectivo();
        p.setFdp(a);
        p.pagarConsulta();

        assertEquals("Pago con efectivo", p.getFdp().toString());
        assertFalse(p.getDebe());
        assertEquals(a, p.getFdp());

    }
}