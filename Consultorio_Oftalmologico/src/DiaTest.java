import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

class DiaTest {

    @Test
    void verificarHora() {
        Dia dia=new Dia(DayOfWeek.MONDAY);
        assertEquals(true,dia.verificar("09:30") );
    }

    @Test
    void verificarHoraMala() {
        Dia dia=new Dia(DayOfWeek.MONDAY);
        assertEquals(false,dia.verificar("9:536") );
    }

    @Test
    void disponible() {
        Dia dia=new Dia(DayOfWeek.MONDAY);
        assertEquals(true,dia.estaDisponible());
    }
}