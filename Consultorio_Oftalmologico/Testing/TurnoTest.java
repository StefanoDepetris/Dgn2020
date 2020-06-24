import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

        String testInput = "Stefano\n" + // Nombre
                "123\n" + // DNI
                "123"; // Telefono
        Scanner mockScanner = new Scanner(testInput);
        Turno turno=new Turno(mockScanner);


    @Before
    public void iniciarComponentes() {

        Turno turno = new Turno(mockScanner);

    }

    @Test
    void comprobarPaciente() {

        assertTrue(turno.comprobarPaciente("Stefano"));
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