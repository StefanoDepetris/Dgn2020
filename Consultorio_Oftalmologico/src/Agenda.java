import java.time.format.DateTimeParseException;
import java.util.*;

public class Agenda implements Subject {

    private final List<Turno> turnos;
    private final ArrayList<Observer> observers;

    public Agenda(){
        turnos = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public boolean crearTurno(String fecha, String hora, String nombre, Integer dni, String telefono) {

        try {
            if (Turno.verificarFecha(fecha, hora)) {
                Turno t = new Turno(nombre, dni, telefono);
                t.setTurno(fecha, hora);
                turnos.add(t);
                notificar();
                return true;
            }
        } catch (FechaIncorrectaException a){
            System.out.println("AGENDA EXCEPTION: Ha introducido una fecha invalida. No se creado el turno");
            return false;
        } catch (DateTimeParseException a){
            System.out.println("AGENDA EXCEPTION: Ha introducido una fecha incompleta. No se creado el turno");
            return false;
        } catch (NullPointerException a ){
            System.out.println("AGENDA EXCEPTION: Ha introducido una hora invalida. No se creado el turno");
            return false;
        }

        System.out.println("AGENDA: el turno está ocupado");
        return false;

    } // False si está ocupada esa hora. True en cualquier otro caso.
    public void crearTurno(String nombre, Integer dni, String telefono){
        Turno t = new Turno(nombre, dni, telefono);
        t.proximoTurno();
        turnos.add(t);
        notificar();
    } // Crea el próximo turno disponible
    private void ordenarTurnos(){
        turnos.sort(new Comparator<Turno>() {
            @Override
            public int compare(Turno t1, Turno t2) {
                return t1.getID().compareTo(t2.getID());
            }
        });

    } // Ordena los turnos por id
    public Turno getTurno(Integer IDoDNI) {
        for (Turno t : turnos){
            if(t.getID().equals(IDoDNI)){
                return t;
            } else if (t.comprobarDNI(IDoDNI)){
                return t;
            }
        }
        return null;
    }
    public boolean quitarTurno(Integer IDoDNI) {

        Turno t = getTurno(IDoDNI);
        try{
            t.borrarTurno();
        } catch (NullPointerException e) {
            System.out.println("AGENDA EXCEPTION: El turno no existe");
            return false;
        }
        turnos.remove(t);
        System.out.println("AGENDA: Turno borrado con exito.");
        notificar();
        return true;
    }
    public boolean cambioTurno (Integer IDoDNI,String fecha, String hora) {

        try {
            if (Turno.verificarFecha(fecha, hora)) {

                Turno t = getTurno(IDoDNI);

                    t.borrarTurno();
                    t.setTurno(fecha, hora);
                    System.out.println("AGENDA: Turno cambiado con éxito.");
                    return true;

            }
        } catch (FechaIncorrectaException a) {
            System.out.println("AGENDA EXCEPTION: Ha introducido una fecha invalida. No se creado el turno");
            return false;
        } catch (NullPointerException e) {
            System.out.println("AGENDA EXCEPTION: ERROR. Paciente no encontrado.");
            return false;
        }
        System.out.println("AGENDA: Horario no disponible.");
        return false;
    }
    public boolean pagar(Integer IDoDNI, Integer forma) {

        Turno t = getTurno(IDoDNI);
        try{
            t.pagarTurno(forma);
            return true;
        } catch (NullPointerException a){
            System.out.println("AGENDA: No existe el turno solicitado. No se realizo el pago.");
            return false;
        }
    }
    public void imprimirTurnos(){
        System.out.printf("AGENDA: Cantidad de turnos: %s \n", cantidadTurnos());
        ordenarTurnos();
        for (Turno t : turnos){
            System.out.println(t);
        }
    }
    public int cantidadTurnos(){
        return turnos.size();
    }
    public List<Turno> getTurnos() {
        return turnos;
    }
    public boolean setAusente(Integer IDoDNI){

        Turno t = getTurno(IDoDNI);
        try {
            t.setAusente();
        }catch (NullPointerException a) {
            System.out.println("AGENDA EXCEPTION: El turno no existe");
            return false;
        }
        turnos.remove(t);
        notificar();
        System.out.println("AGENDA: Turno marcado como ausente y borrado.");
        return true;
    }
    public void reiniciarAgenda(){
        for (Turno t : getTurnos()){
            t.borrarTurno();
        }
        turnos.clear();
    }

    //------------------------------------OBSERVERS---------------------------------------------------------------------

    @Override
    public void registrarObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void eliminarObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificar() {
        for (Observer o : observers){
            o.update();
        }
    }
}