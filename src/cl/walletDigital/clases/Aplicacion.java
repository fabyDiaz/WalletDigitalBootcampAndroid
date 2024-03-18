package cl.walletDigital.clases;

import java.util.Scanner;

public class Aplicacion {

    Scanner scanner = new Scanner(System.in);
    ListaClientes listaClientes = new ListaClientes();


    public void bienvenida() {
        System.out.println("*************************************");
        System.out.println("*     Bienvenido a Alke Wallet      *");
        System.out.println("*  Tu solución digital financiera   *");
        System.out.println("*************************************");
    }

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
                        listaClientes.getListaClientes().add(cliente.crearCliente());
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

    public void menuCuentaUsuario() {
        int opcion;
        byte salir;
        Cliente cliente = ingresoCuenta();
        boolean valido = false;
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

    private static Cliente validarCredenciales(String correo, String contrasena, Cliente cliente) {
        if (correo.equals(cliente.getCorreoElectronico()) && cliente.validarContraseña(contrasena)) {
            return cliente;
        }
        return null;
    }


}
