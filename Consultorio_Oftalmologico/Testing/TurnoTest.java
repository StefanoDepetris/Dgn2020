import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

        Turno turno = new Turno("Macarena",564654,"52465");


    @Before
    public void iniciarComponentes() {

    }

    @Test
    void comprobarPaciente() {

        assertTrue(turno.comprobarPaciente("Macarena"));
    }

    @Test

    void comprobarFecha() throws FechaIncorrectaException {

        assertTrue(Turno.verificarFecha("2020-07-24", "12:00"));

    }
    @Test
    void comprobarFechaVieja() {

        assertThrows(FechaIncorrectaException.class, () -> Turno.verificarFecha("2020-05-24", "12:00"));

    }


}