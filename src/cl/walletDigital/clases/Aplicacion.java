package cl.walletDigital.clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacion {

    Scanner scanner = new Scanner(System.in);
    ListaClientes listaClientes = new ListaClientes();
    Cliente cliente = new Cliente();


    /**
     * Mensaje de Bienvenida
     */
    public void bienvenida() {
        System.out.println("*************************************");
        System.out.println("*     Bienvenido a Alke Wallet      *");
        System.out.println("*  Tu solución digital financiera   *");
        System.out.println("*************************************");
    }


    /**
     * Método que muestra el menú de inicio de la App AlkWallet
     * En este menú se despliega la opciones de crear una cuenta o ingrear con una cuenta existente.
     * Si decide ingresar ocn una cuenta exitente, tendrá un máximo de 3 intentos, de lo contrario se termina la ejecución.
     */
    public void menuInicioApp() {
        int opcion=0;
        boolean entradaValida=false;
        do {
            try {
                System.out.println("    1. Registrar");
                System.out.println("    2. Iniciar Sesión");
                System.out.println("    3. Mostrar lista clientes");
                System.out.println("    4. Salir");
                System.out.println("    Selecciona una opción");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                       // listaClientes.getListaClientes().add(cliente.crearCliente());
                        listaClientes.addCliente(cliente.crearCliente());
                        scanner.nextLine();
                        break;
                    case 2:
                        menuCuentaUsuario();
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println(listaClientes.getListaClientes());
                        scanner.nextLine();
                    case 4:
                        System.out.println("Hasta la proxima!");
                        scanner.nextLine();
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                        entradaValida = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (!entradaValida|| opcion != 4);
    }

    /**
     *  Verifica que el correo y la contraseña ingresada ya se encuntra registrado.
     *  Si lo encuntra devuelve al Cliente
     * @return retorna el cliente luego de verificar que el correo y la contraseña ingresada sea correcta
     *
     */
    public boolean inicioSesion() {
        String correo, contrasena;
        int intentos = 0;
        boolean loginExitoso = false;

        while (intentos < 3 && !loginExitoso) {
            System.out.println("Ingrese su correo electrónico:");
            correo = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            contrasena = scanner.nextLine();

            // Validar usuario y contraseña
           for (int i = 0; i < listaClientes.getListaClientes().size(); i++) {
                cliente = validarCredenciales(correo, contrasena, listaClientes.getListaClientes().get(i));
            }
            if (cliente != null) {
                loginExitoso = true;
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + cliente.getNombreCliente() + "!");
                // Aquí puedes continuar con la lógica de la aplicación
            } else {
                intentos++;
                System.out.println("Correo electrónico o contraseña incorrectos. Intento " + intentos + " de 3.");
            }

        }
        return loginExitoso;
    }

    /**
     * Este es el menú que se muestra una vez que el cliente haya ingresado a su cuenta
     */
    public void menuCuentaUsuario() {
        int opcion=0;
        boolean entradaValida = false;
        double dinero;
        if(inicioSesion()==true){
            do {
                System.out.println("");
                System.out.println("---------------------------------");
                System.out.println("SALDO: "+cliente.getCuentaCliente().formatearModena(cliente.getCuentaCliente().getSaldo()));
                System.out.println("---------------------------------");
                try {
                    System.out.println("Selecciona una opción:\n"+
                                        "1.-    Ver mis datos\n"+
                                        "2.-    Ver datos de mi cuenta\n"+
                                        "3.-    Ingresar dinero\n"+
                                        "4.-    Transferir dinero\n"+
                                        "5.-    Retirar dinero\n"+
                                        "6.-    Ver movimientos\n"+
                                        "7.-    Salir");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion) {
                        case 1:
                            cliente.mostrarDatosCliente();
                            break;
                        case 2:
                            cliente.getCuentaCliente().MostrarDatosCuenta();
                            break;
                        case 3:
                            System.out.println("Ingrese Monto: ");
                            dinero=scanner.nextDouble();
                            cliente.getCuentaCliente().ingresoDinero(dinero);
                            break;
                        case 4:
                            System.out.println("aquí podrás trnaferir dinero");
                            break;
                        case 5:
                            System.out.println("¿Cuánto vas a retirar?");
                            dinero=scanner.nextDouble();
                            cliente.getCuentaCliente().retiroDinero(dinero);
                            break;
                        case 6:
                            System.out.println("Aquí podrás ver tus movimientos");
                            break;
                        case 7:
                            System.out.println("Hasta pronto!");
                        default:
                            System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                            entradaValida = false;
                            break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Solo números");
                }
            } while (!entradaValida || opcion != 7);
        }
    }


    /**
     *Valida si el correo y contraseña ingresado coincide con el cliente de la lista.
     * En caso que coincidan, devuelve el cliente.
     * @param correo
     * @param contrasena
     * @param cliente
     * @return
     */
    private static Cliente validarCredenciales(String correo, String contrasena, Cliente cliente) {
        if (correo.equals(cliente.getLogin().getEmailCliente()) && cliente.getLogin().validarContrasena(contrasena)) {
            return cliente;
        }
        return null;
    }


}
