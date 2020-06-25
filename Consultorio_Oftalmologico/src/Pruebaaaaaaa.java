

public class Pruebaaaaaaa {
    public static void main(String[] args) {

        System.out.println("INICIO DE LA PRUEBA \n");
        Agenda agenda = new Agenda();
        agenda.crearTurno("Marcos", 40775432, "3845564864");
        agenda.crearTurno("2020-07-26", "09:30", "Stefano", 4056654, "12654645");
        agenda.imprimirTurnos();
        agenda.setAusente(40775432);
        agenda.imprimirTurnos();






        System.out.println("\nFIN DE LA PRUEBA");

    }




}
