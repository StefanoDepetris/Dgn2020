import java.util.Scanner;


public class Pruebaaaaaaa {
    public static void main(String[] args) {

        System.out.println("INICIO DE LA PRUEBA \n");

        Agenda miAgenda = new Agenda(new Scanner(System.in));
        new ObserverAusencia(miAgenda);
        miAgenda.crearTurno();
        miAgenda.Ausente(40775432);
        miAgenda.imprimirTurnos();

        System.out.println("\nFIN DE LA PRUEBA");
    }




}
