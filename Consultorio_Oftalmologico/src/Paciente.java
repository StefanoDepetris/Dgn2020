import java.io.BufferedReader;
import java.text.Normalizer;
import java.util.Scanner;

public class Paciente {
     private String nombre;
     private Integer dni;
     private Long telefono;
     private Boolean debe = false;
     private FormaDePago miForma;

    public Paciente (Scanner sc) {
        crearPaciente(sc);
    }

    public void crearPaciente (Scanner input){
        setNombre(input.nextLine());

        setDNI(input.nextInt());

        setTelefono(input.nextLong());
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    public void setDNI(int dni) {

        this.dni=dni;
    }
    public void setTelefono(long telefono) {
        this.telefono=telefono;
    }
    public String getNombre() {
        return  nombre;
    }
    public Integer getDNI() {
        return  dni;
    }
    public Long getTelefono() {
        return  telefono;
    }
    public void pagarConsulta() {
        miForma.pagar();
    }
    public void setFdp(FormaDePago fdp ) {
        miForma = fdp;
    }
    public FormaDePago getFdp(){
        return miForma;
    }
    public Boolean getDebe() {
        return debe;
    }



}
