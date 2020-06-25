import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    Paciente p = new Paciente("Macarena",40884,"45451");

    @Test
    void pagarConsultaEfectivo() {

        FormaDePago a = new Efectivo();
        p.setFdp(a);
        p.pagarConsulta();

        assertEquals("Pago con efectivo", p.getFdp().toString());
        assertFalse(p.getDebe());
        assertEquals(a, p.getFdp());

    }
    @Test
    void pagarConsultaCredito() {

        FormaDePago a = new TarjetaCredito();
        p.setFdp(a);
        p.pagarConsulta();

        assertEquals("Pago con credito", p.getFdp().toString());
        assertFalse(p.getDebe());
        assertEquals(a, p.getFdp());

    }
    @Test
    void pagarConsultaDebito() {

        FormaDePago a = new TarjetaDebito();
        p.setFdp(a);
        p.pagarConsulta();

        assertEquals("Pago con debito", p.getFdp().toString());
        assertFalse(p.getDebe());
        assertEquals(a, p.getFdp());

    }

}