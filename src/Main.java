import cl.walletDigital.clases.Cliente;
import cl.walletDigital.clases.ListaClientes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        byte salir;
        Cliente cliente=new Cliente();
        ListaClientes listaClientes = new ListaClientes();
        System.out.println("*************************************");
        System.out.println("*     Bienvenido a Alke Wallet      *");
        System.out.println("*  Tu solución digital financiera   *");
        System.out.println("*************************************");

        do {
            try {
                System.out.println("    1. Crear cuenta");
                System.out.println("    2. Ingresar");
                System.out.println("    Selecciona una opción");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion){
                    case 1:
                        cliente.crearCliente();
                        listaClientes.getListaUsuarios().add(cliente);
                        break;
                    case 2:
                        System.out.println(listaClientes.getListaUsuarios());
                        break;
                }
            }catch(Exception e) {
                System.out.println("Error " + e.getMessage());
            }
            System.out.println("SALIR  1.NO 2.SI");
            salir= scanner.nextByte();
        }while(salir==2);

    }
}