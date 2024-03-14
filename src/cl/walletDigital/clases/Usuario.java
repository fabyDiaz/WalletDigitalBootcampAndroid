package cl.walletDigital.clases;

public class Usuario {

    private String nombre;
    private String apellido;
    private String rut;
    private int telefono;
    private int clave;
    private Cuenta cuentaUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String rut, int telefono, int clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void crearCuenta() {
        String nombreCompleto = (this.nombre + " " + this.apellido).toUpperCase();
        if (cuentaUsuario == null) {
            cuentaUsuario = new Cuenta(789654, nombreCompleto, 0);
            System.out.println("Cuenta creada para el usuario " + nombre);
        } else {
            System.out.println("El usuario ya tiene una cuenta asociada.");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", telefono=" + telefono +
                ", clave=" + clave +
                '}';
    }
}
