import cl.walletDigital.clases.Cuenta;
import cl.walletDigital.clases.ListaUsuarios;
import cl.walletDigital.clases.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("*     Bienvenido a Alke Wallet      *");
        System.out.println("*  Tu solución digital financiera   *");
        System.out.println("*************************************");

        //Variables
        int opcion, telefono, clave, accionUsuario;
        String nombre, apellido, rut, nombreCompleto;
        boolean valido;
        Usuario nuevoUsuario;
        Cuenta cuentaUsuario;
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        List<Usuario> usuarios = listaUsuarios.getListaUsuarios();

        //Menú
        do {

            // Aca muestro por pantalla
            System.out.println("    1. Iniciar sesión");
            System.out.println("    2. Crear cuenta");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Ingrese clave");
                        clave = scanner.nextInt();
                        for (int i = 0; i < usuarios.size(); i++) {
                            if (clave == usuarios.get(i).getClave()) {
                                valido = true;
                            } else {
                                valido = false;
                            }
                        }
                    } while (valido = false);
                    break;
                case 2:
                    System.out.println("        System.out.println(\"*************************************\");\n" +
                            "        System.out.println(\"*     Crear Cuenta    *\");\n" +
                            "        System.out.println(\"*************************************\");");
                    System.out.println("Ingrese su nombre");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese su apellido");
                    apellido = scanner.nextLine();
                    System.out.println("Ingrese su rut");
                    rut = scanner.nextLine();
                    System.out.println("Ingrese su numero de teléfono");
                    telefono = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese su clave secreta");
                    clave = Integer.parseInt(scanner.nextLine());

                    nuevoUsuario = new Usuario(nombre, apellido, rut, telefono, clave);
                    nuevoUsuario.crearCuenta();
                    usuarios.add(nuevoUsuario);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

            System.out.println("presion 1 para continuar, 0 para salir");
            accionUsuario = Integer.parseInt(scanner.nextLine());
        } while (accionUsuario == 1);
        System.out.println("Sesión Finalizada");
    }
    public static int menuCuenta(Usuario usuario){


        return 0;

    }


}