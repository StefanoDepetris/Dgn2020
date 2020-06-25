import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    @Test
    void comprobarPaciente() {
        String testInput = "Stefano\n" + // Nombre
                "123\n" + // DNI
                "123"; // Telefono
        Scanner mockScanner = new Scanner(testInput);
        Turno turno=new Turno(mockScanner);
        assertEquals(true,turno.comprobarPaciente("Stefano"));
    }
    @Test
    void comprobarFecha() throws FechaIncorrectaException {
        String testInput = "Stefano\n" + // Nombre
                "123\n" + // DNI
                "123"; // Telefono
        Scanner mockScanner = new Scanner(testInput);
        Turno turno=new Turno(mockScanner);
        assertEquals(true,turno.verificarFecha("2020-06-24", "12:00"));

    }
}