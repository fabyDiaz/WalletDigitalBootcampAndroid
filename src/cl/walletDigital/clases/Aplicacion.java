package cl.walletDigital.clases;

import java.util.Scanner;

public class Aplicacion {

    Scanner scanner = new Scanner(System.in);
    ListaClientes listaClientes = new ListaClientes();


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
        int opcion;
        byte salir;
        Cliente cliente = new Cliente();
        ListaClientes listaClientes = new ListaClientes();

        do {
            try {
                System.out.println("    1. Crear cuenta");
                System.out.println("    2. Ingresar");
                System.out.println("    3. Mostrar lista clientes");
                System.out.println("    Selecciona una opción");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                       // listaClientes.getListaClientes().add(cliente.crearCliente());
                        listaClientes.addCliente(cliente.crearCliente());
                        break;
                    case 2:
                        menuCuentaUsuario();
                        break;
                    case 3:
                        System.out.println(listaClientes.getListaClientes());
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
            System.out.println("SALIR:  1.NO     2.SI");
            salir = scanner.nextByte();
        } while (salir == 1);
    }

    /**
     *  Verifica que el correo y la contraseña ingresada ya se encuntra registrado.
     *  Si lo encuntra devuelve al Cliente
     * @return retorna el cliente luego de verificar que el correo y la contraseña ingresada sea correcta
     *
     */
    public Cliente ingresoCuenta() {
        String correo, contrasena;
        Cliente cliente = null;
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
        return cliente;
    }

    /**
     * Este es el menú que se muestra una vez que el cliente haya ingresado a su cuenta
     */
    public void menuCuentaUsuario() {
        int opcion;
        byte salir;
        Cliente cliente = ingresoCuenta();
        do {
            try {
                System.out.println("    1. Ver mis datos");
                System.out.println("    2. Ver datos de mi cuenta");
                System.out.println("    Selecciona una opción");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        cliente.mostrarDatosCliente();
                        break;
                    case 2:
                        cliente.getCuentaCliente().MostrarDatosCuenta();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
            System.out.println("SALIR:  1.NO     2.SI");
            salir = scanner.nextByte();
        } while (salir == 2);
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
        if (correo.equals(cliente.getCorreoElectronico()) && cliente.validarContrasena(contrasena)) {
            return cliente;
        }
        return null;
    }


}
