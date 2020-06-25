import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class Turno {

    private Fecha fecha;
    private LocalTime hora;
    private Paciente paciente;
    private boolean ausente;



    //-------------------CONFIGURACION INICIAL (LO MISMO PARA TODAS LAS INSTANCIAS DE DIA)------------------------------

    static private ArrayList<Fecha> fechas;
    static private Integer id;
    private Integer myid;

    static  {
        fechas = new ArrayList<>();
        fechas.add(new Fecha(LocalDate.now()));
        id = 0;
    }  // ESTO SE HACE SOLO AL INICIO


    //------------------------------------CONSTRUCTOR-------------------------------------------------------------------

    public Turno (String nombre, Integer dni, String telefono ) {
        myid = ++id;
        paciente = new Paciente(nombre, dni, telefono);
        ausente=false;
    }

    //--------------------------METODOS IMPORTANTES---------------------------------------------------------------------

    public void setTurno(String fecha, String hora) {
        ordenarFechas();
        LocalDate fechaBuscada = LocalDate.parse(fecha);
        for (Fecha f : fechas){
            if (f.getFecha().equals(fechaBuscada)){
                f.cambiarHora(hora);
                setFecha(f, hora);
                System.out.printf("TURNO: Turno personalizado agregado con éxito. %s \n", this);
                return;
            }
        }

        System.out.println("TURNO: ERROR EN setTurno");
    } // Setea el turno personalizado en la fecha indicada.
    static boolean verificarFecha(String s, String hora) throws FechaIncorrectaException {
        ordenarFechas();
        if (!fechas.get(0).getFecha().isBefore(LocalDate.parse(s))){
            throw new FechaIncorrectaException();
        }
        LocalDate fechaBuscada = LocalDate.parse(s);
        for (Fecha f : fechas){
            if (f.getFecha().equals(fechaBuscada)) {
                return f.verificarHora(hora);
            }
        }

        do {
            Fecha f = new Fecha((fechas.get(fechas.size()-1).getFecha().plusDays(1)));
            fechas.add(f);
            ordenarFechas();
        } while (!fechas.get(fechas.size()-1).getFecha().equals(fechaBuscada));

        return verificarFecha(s, hora);
    } //False si la hora está ocupada, True si está disponible y
    // si no existe la fecha, crea fechas hasta llegar a la fecha pedida y además tira true.
    public void proximoTurno () {
        ordenarFechas();
        for (Fecha f: fechas) {
            if(f.verificarDisponibilidad()){
                String hora = f.obtenerProximaHora();
                setFecha(f,hora);
                System.out.printf("TURNO: Turno agregado en el proximo horario disponible. %s \n", this);
                return;
            }
        }
        System.out.println("PUNTO A");
        Fecha f = new Fecha((fechas.get(fechas.size()-1).getFecha().plusDays(1)));
        String hora = f.obtenerProximaHora();
        setFecha(f, hora);
        System.out.printf("Turno agregado con éxito. Fecha y hora: %s", this);


    } //Setea el proximo turno disponible

    //----------------------------METODOS SIMPLES-----------------------------------------------------------------------

    public void pagarTurno(Integer a) {
        if (!paciente.getDebe()){
            System.out.println("TURNO: El turno ya se ha pagado amteriormente.");
            return;
        }
        switch (a){
            case 0:
                paciente.setFdp(new TarjetaDebito());
                break;
            case 1:
                paciente.setFdp(new TarjetaCredito());
                break;
        }

        paciente.pagarConsulta();
    }
    public boolean comprobarPaciente(String nombre) {
        return paciente.getNombre().equals(nombre);
    }
    public boolean comprobarDNI(Integer dni) {
        return paciente.getDNI().equals(dni);
    }
    public void setFecha(Fecha fecha, String hora) {

        this.fecha=fecha;
        this.hora=LocalTime.parse(hora);
        fechas.add(fecha);
    }
    static void ordenarFechas () {

        fechas.sort(new Comparator<Fecha>() {
            @Override
            public int compare(Fecha f1, Fecha f2) {
                return f1.getFecha().compareTo(f2.getFecha());
            }
        });
    } // Ordena la lista de fechas
    public Integer getID () {
        return myid;
    } //Devuelve el id de turno
    public void borrarTurno() {
        fecha.cambiarHora(hora.toString());
    }
    public boolean getAusente(){
        return ausente;
    }
    public void setAusente(){
        ausente = true;
        borrarTurno();
    }


    @Override
    public String toString(){
        return "Fecha: " + fecha + " a las " + hora + "Paciente: " + paciente.toString();
    }

    //-----------------------------METODOS DE PRUEBA--------------------------------------------------------------------

    public String getHora(){
        return hora.toString();
    }
    public String getFecha(){
        return fecha.toString();
    }

}