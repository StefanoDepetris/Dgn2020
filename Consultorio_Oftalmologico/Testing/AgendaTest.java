import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AgendaTest {
    String testInput = "Stefano\n" + // Nombre
            "123\n" + // DNI
            "123"; // Telefono
    Scanner mockScanner = new Scanner(testInput);
    Agenda agenda = new Agenda(mockScanner);

    @Test
    void crearTurno() {
        assertEquals(true, agenda.crearTurno("2020-06-24", "12:00"));
    }
    @Test
    void crearTurnodoble() {
        assertEquals(true, agenda.crearTurno("2020-06-24", "11:30"));
        assertEquals(false, agenda.crearTurno("2020-06-24", "11:30"));
    }
    @Test
    void quitarTurno() {
        agenda.crearTurno("2020-06-24", "10:30");
        assertEquals(true, agenda.quitarTurno(1));
    }
    @Test
    void quitarTurnoNoExistente() {
        //agenda.crearTurno("2020-06-24", "10:30");
        assertEquals(false, agenda.quitarTurno(213));
    }
    @Test
    void cambioTurno() {

        agenda.crearTurno("2020-06-25", "12:00");
        assertEquals(true, agenda.cambioTurno(4, "2020-06-24", "08:00"));
    }

    @Test
    void pagarNopresente() {
        agenda.crearTurno("2020-06-24", "08:30");
        assertEquals(false, agenda.pagar(6));
    }
}