package cl.walletDigital.clases;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String rutCliente;
    private String correoElectronico;
    private String telefonoCliente;
    private String contrasena;
    private Cuenta cuentaCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String rutCliente, String correoElectronico, String telefonoCliente, String contrasena, Cuenta cuentaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.rutCliente = rutCliente;
        this.correoElectronico = correoElectronico;
        this.telefonoCliente = telefonoCliente;
        this.contrasena = contrasena;
        this.cuentaCliente = cuentaCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public boolean validarContraseña(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public Cuenta getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(Cuenta cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", rutCliente='" + rutCliente + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", cuentaCliente=" + cuentaCliente +
                '}';
    }

    public String nombreCompleto(){
        return this.nombreCliente + " " + this.apellidoCliente;
    }

    public void generarId(){
        this.idCliente = (int)Math.random()*1000000;
    }

    public Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);
        int nuevoId;

        System.out.println("Ingrese los siguientes datos");
        System.out.println("-------------------------------");
        System.out.println("NOMBRE: ");
        this.nombreCliente = scanner.nextLine();
        System.out.println("APELLIDO: ");
        this.apellidoCliente = scanner.nextLine();
        do{
            System.out.println("RUT (en formato xxxxxxxx-x: ");
            this.rutCliente = scanner.nextLine();
        }while(validarRut(rutCliente)==false);
        System.out.println("EMAIL:");
        this.correoElectronico = scanner.nextLine();
        System.out.println("TELÉFONO");
        this.telefonoCliente = scanner.nextLine();
        System.out.println("CREA UNA CONTRASEÑA");
        this.contrasena = scanner.nextLine();

        Cuenta nuevaCuenta = Cuenta.crearCuenta(nombreCompleto().toUpperCase());

        return new Cliente(idCliente, nombreCliente, apellidoCliente, rutCliente, correoElectronico, telefonoCliente, contrasena, nuevaCuenta);

    }

    public void mostrarDatosCliente(){
        System.out.println("===============================");
        System.out.println("Los datos son: ");
        System.out.println("------------------------------");
        System.out.println("ID: ");
        System.out.println("NOMBRE: "+nombreCompleto());
        System.out.println(("RUT: "+ this.rutCliente));
        System.out.println("CORREO: "+this.correoElectronico);
        System.out.println("TELÉFONO "+this.telefonoCliente);
    }

    /**
     *  Valida rut de la forma XXXXXXXX-X
     */
    public Boolean validarRut ( String rut ) {
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if ( matcher.matches() == false ) return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
    }

    /**
     * Valida el dígito verificador
     */
    public String dv ( String rut ) {
        Integer M=0,S=1,T=Integer.parseInt(rut);
        for (;T!=0;T=(int) Math.floor(T/=10))
            S=(S+T%10*(9-M++%6))%11;
        return ( S > 0 ) ? String.valueOf(S-1) : "k";
    }


}
