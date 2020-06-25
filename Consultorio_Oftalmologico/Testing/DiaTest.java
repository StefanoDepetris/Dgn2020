import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DiaTest {

    @Test
    void cambiaEstadoDeHora() {
        Dia dia=new Dia(DayOfWeek.MONDAY);

        assertTrue(dia.verificar("09:30"));

        dia.CambiaEstadoDeHora("09:30");

        assertFalse(dia.verificar("09:30"));

    }

    @Test
    void verificarHoraMala() {
        Dia dia=new Dia(DayOfWeek.MONDAY);
        assertFalse(dia.verificar("9:536"));
    }

    @Test
    void disponible() {
        Dia dia=new Dia(DayOfWeek.MONDAY);

        assertTrue(dia.estaDisponible());

        for (LocalTime t : dia.getHoras().keySet()){
            dia.getHoras().put(t, false);
        }

        assertFalse(dia.estaDisponible());
    }

}