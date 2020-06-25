import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    Paciente p = new Paciente("Macarena",40884,"45451");

    @Test
    void pagarConsulta() {

        FormaDePago a = new Efectivo();
        p.setFdp(a);
        p.pagarConsulta();

        assertEquals("Pago con efectivo", p.getFdp().toString());
        assertFalse(p.getDebe());
        assertEquals(a, p.getFdp());

    }
}