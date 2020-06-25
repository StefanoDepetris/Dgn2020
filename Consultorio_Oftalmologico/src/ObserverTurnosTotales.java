
public class ObserverTurnosTotales implements Display, Observer {

    private Agenda miAgenda;
    private Integer turnos;

    public ObserverTurnosTotales (Agenda a) {
        miAgenda = a;
        miAgenda.registrarObserver(this);
        turnos = 0;
    }

    @Override
    public void display() {
        System.out.println("\n" + this);
    }

    @Override
    public void update(){
        if (turnos != miAgenda.cantidadTurnos()){
            turnos = miAgenda.cantidadTurnos();
            display();
        }
    }

    @Override
    public String toString() {
        return "OBSERVER TURNOS: " + turnos + " turnos totales." + "\n";
    }

}
