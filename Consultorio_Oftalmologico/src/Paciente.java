public class Paciente {
    private String nombre;
    private Integer dni;
    private String telefono;
    private Boolean debe = true;
    private FormaDePago miForma;

    public Paciente (String nombre, Integer dni, String telefono) {
        crearPaciente(nombre, dni, telefono);
    }

    public void crearPaciente (String nombre, Integer dni, String telefono){
        setNombre(nombre);

        setDNI(dni);

        setTelefono(telefono);
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    public void setDNI(int dni) {

        this.dni=dni;
    }
    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }
    public String getNombre() {
        return  nombre;
    }
    public Integer getDNI() {
        return  dni;
    }
    public String getTelefono() {
        return  telefono;
    }
    public void pagarConsulta() {
        miForma.pagar();
        debe = false;
    }
    public void setFdp(FormaDePago fdp ) {
        miForma = fdp;
    }
    public FormaDePago getFdp(){
        return miForma;
    }
    public boolean getDebe() {
        return debe;
    }

    @Override
    public String toString(){
        String s = this.getDebe() ? "Si": miForma.toString();
        return this.getNombre() + this.getDNI() + this.getTelefono() + s;
    }



}