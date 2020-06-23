import java.io.BufferedReader;
import java.util.Scanner;

public class Paciente {
     private String nombre;
     private Integer dni;
     private Long telefono;
     BufferedReader br ;
     FormaDePago miForma;

    public Paciente () {
        crearPaciente();
    }

    private void crearPaciente (){

        Scanner sc = new Scanner(System.in);
        System.out.println("PACIENTE: Ingrese nombre del paciente: ");
        setNombre(sc.nextLine());
        System.out.println("PACIENTE: Ingrese DNI sin puntos del paciente: ");
        setDNI(sc.nextInt());
        System.out.println("PACIENTE: Ingrese telefono del paciente: ");
        setTelefono(sc.nextLong());
        System.out.println("PACIENTE: Paciente creado con éxito");
    }
    public void setNombre(String nombre) { this.nombre=nombre; }
    public void setDNI(int dni) {
        this.dni=dni;
    }
    public void setTelefono(long telefono) { this.telefono=telefono; }
    public String getNombre() { return  nombre; }
    public Integer getDNI() { return  dni; }
    public Long getTelefono() { return  telefono; }

    public void pagarConsulta() { miForma.pagar(); }

    public void setFdp(FormaDePago fdp ) {
        miForma = fdp;
    }



}
