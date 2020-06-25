import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class AgendaTest {
    Agenda agenda = new Agenda();


    @Before
    public void iniciarComponentes() {
            agenda.reiniciarAgenda();
    }

    @Test
    public void crearTurno() {
        assertTrue(agenda.crearTurno("2020-07-25", "12:00","Marcos",40775432,"38048442"));
    }
    @Test
    public void crearTurnoSinFechaProximoDisponible() {
        agenda.crearTurno(40775432,"3804807274","Marcos");

    }

    @Test
    public void crearTurnodoble() {
        assertTrue(agenda.crearTurno("2020-07-24", "11:30","Marcos",40775432,"38048442"));
        assertFalse(agenda.crearTurno("2020-07-24", "11:30","Stefano",405552,"38048542"));

    }

    @Test
    public void quitarTurno() {
        agenda.crearTurno("2020-07-24", "11:30","Marcos",407756432,"38048442");
        assertTrue(agenda.quitarTurno(407756432));
        assertNull(agenda.getTurno(40775432));
    }

    @Test
    public void quitarTurnoNoExistente() {
        assertFalse(agenda.quitarTurno(213));
    }



    @Test
    public void cambioTurnos() {
        agenda.crearTurno("2020-07-24", "11:30","Marcos",40775432,"38048442");
        assertTrue(agenda.cambioTurno(40775432, "2020-07-28", "09:00"));
    }

    @Test
    public void pagarTurnoInexistente() {
        assertFalse(agenda.pagar(123));
    }

    @Test
    public void PacienteAusenteTurnoBorrado() {
        agenda.crearTurno("2020-07-24", "11:30","Marcos",40775432,"38048442");
        assertTrue(agenda.setAusente(40775432));
        assertFalse(agenda.setAusente(40775432));
    }




}