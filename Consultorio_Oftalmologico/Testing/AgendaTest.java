import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class AgendaTest {


        String testInput = "Stefano\n" + // Nombre
                "123\n" + // DNI
                "12345"; // Telefono
        Scanner mockScanner = new Scanner(testInput);
        Agenda agenda = new Agenda(mockScanner);


    @Before
    public void iniciarComponentes() {

    }

    @Test
    public void crearTurno() {
        assertTrue(agenda.crearTurno("2020-07-25", "12:00"));
    }

    @Test
    public void crearTurnoDoble() {
        assertTrue(agenda.crearTurno("2020-07-24", "11:30"));
        assertFalse(agenda.crearTurno("2020-07-24", "11:30"));
    }

    @Test
    public void quitarTurno() {
        agenda.crearTurno("2020-07-24", "10:30");
        assertTrue(agenda.quitarTurno(123));
        assertNull(agenda.getTurno(123));
    }

    @Test
    public void quitarTurnoNoExistente() {
        assertFalse(agenda.quitarTurno(213));
    }



    @Test
    public void cambioTurno() {

        agenda.crearTurno("2020-08-25", "12:00");
        assertTrue(agenda.cambioTurno(123, "2020-07-28", "09:00"));
    }

    @Test
    public void pagarTurnoInexistente() {
        assertFalse(agenda.pagar(123));
    }

    @Test
    public void PacienteAusenteTurnoBorrado() {
        agenda.crearTurno("2020-07-25", "12:00");
        assertTrue(agenda.setAusente(123));
        assertFalse(agenda.setAusente(123));
    }




}