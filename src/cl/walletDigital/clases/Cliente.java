package cl.walletDigital.clases;
import java.util.Scanner;

public class Cliente {

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String rutCliente;
    private String correoElectronico;

    private String telefonoCliente;
    private Cuenta cuentaCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String rutCliente, String correoElectronico, String telefonoCliente, Cuenta cuentaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.rutCliente = rutCliente;
        this.correoElectronico = correoElectronico;
        this.telefonoCliente = telefonoCliente;
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
                ", cuentaCliente=" + cuentaCliente +'\n'+
                '}';
    }

    public String nombreCompleto(){
        return this.nombreCliente + " " + this.apellidoCliente;
    }

    public void generarId(){
        this.idCliente = (int)Math.random()*1000000;
    }

    public Cliente crearCliente(){
        Scanner scanner = new Scanner(System.in);
        int nuevoId;

        System.out.println("Ingrese los siguientes datos");
        System.out.println("-------------------------------");
        System.out.println("NOMBRE: ");
        this.nombreCliente = scanner.nextLine();
        System.out.println("APELLIDO: ");
        this.apellidoCliente = scanner.nextLine();
        System.out.println("RUT: ");
        this.rutCliente = scanner.nextLine();
        System.out.println("EMAIL:");
        this.correoElectronico=scanner.nextLine();
        System.out.println("TELÉFONO");
        this.telefonoCliente= scanner.nextLine();

        Cuenta nuevaCuenta =  Cuenta.crearCuenta(nombreCompleto().toUpperCase());

        return new Cliente(idCliente,rutCliente,nombreCliente, apellidoCliente,correoElectronico,telefonoCliente,nuevaCuenta);

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


}
