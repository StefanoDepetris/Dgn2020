import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

    class DiaTest {

        @Test
        void cambiaEstadoDeHora() {   // LISTOOOOO
            Dia dia=new Dia(DayOfWeek.MONDAY);


            dia.CambiaEstadoDeHora("09:30");

            assertFalse(dia.verificar("09:30"));

        }

        @Test
        void VerificarHorasNuevoDia() {   // LISTOOOOO

            Dia dia=new Dia(DayOfWeek.MONDAY);

            assertTrue(dia.verificar("09:30"));


        }

        @Test
        void verificarHoraMala() {   // LISTOOOOO
            Dia dia=new Dia(DayOfWeek.MONDAY);
            assertFalse(dia.verificar("9:536"));
        }

        @Test
        void disponibleDiaNuevo() {   // LISTOOOOO
            Dia dia=new Dia(DayOfWeek.MONDAY);
            dia.CambiaEstadoDeHora("09:30");
            dia.CambiaEstadoDeHora("10:30");

            assertTrue(dia.estaDisponible());

    }
    @Test
    void disponibleDiaOcupado() {  // LISTOOO

        Dia dia=new Dia(DayOfWeek.MONDAY);

        for (LocalTime t : dia.getHoras().keySet()){
            dia.getHoras().put(t, false);
        }

        assertFalse(dia.estaDisponible());
    }

}