package cl.walletDigital.clases;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String rutCliente;
    private String telefonoCliente;
    private Cuenta cuentaCliente;
    private Login login;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String rutCliente, String telefonoCliente, Cuenta cuentaCliente, Login login) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.rutCliente = rutCliente;
        this.telefonoCliente = telefonoCliente;
        this.cuentaCliente = cuentaCliente;
        this.login = login;
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

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Cuenta getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(Cuenta cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String nombreCompleto(){
        return this.nombreCliente + " " + this.apellidoCliente;
    }

    public void generarId(){
        this.idCliente = (int)Math.random()*1000000;
    }

    Scanner scanner = new Scanner(System.in);

    /**
     * Método que solicita los datos necesarios para crear un nuevo cliente
     * @return nuevo cliente
     */
    public Cliente crearCliente() {
        String email, contrasena;
        Login login1= new Login();

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
        System.out.println("TELÉFONO");
        this.telefonoCliente = scanner.nextLine();

        this.login = login1.CrearCorreoyContrasena();

        this.cuentaCliente = Cuenta.crearCuenta(nombreCompleto().toUpperCase());

        return new Cliente(idCliente, nombreCliente, apellidoCliente, rutCliente, telefonoCliente, cuentaCliente, login);

    }

    public void mostrarDatosCliente(){
        System.out.println("===============================");
        System.out.println("Los datos son: ");
        System.out.println("------------------------------");
        System.out.println("ID: ");
        System.out.println("NOMBRE: "+nombreCompleto());
        System.out.println(("RUT: "+ this.rutCliente));
        System.out.println("CORREO: "+this.login.getEmailCliente());
        System.out.println("TELÉFONO "+this.telefonoCliente);
    }

    /**
     *  Valida rut de la forma XXXXXXXX-X
     */
    public boolean validarRut ( String rut ) {
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if ( matcher.matches() == false ) return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
    }

    public void validarNombre(String nombre){
        boolean salir = false;
        do {
            System.out.println("NOMBRE:");
            nombre = scanner.nextLine();
            if (nombre.matches("[a-zA-Z]{2,30}")){
                salir = true;
            }else {
                System.out.println("Formato incorrecto");
            }
        }while (!salir);
        salir = false;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", rutCliente='" + rutCliente + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", cuentaCliente=" + cuentaCliente +
                ", login=" + login +
                '}';
    }


}
