package cl.walletDigital.clases;

import java.util.Scanner;

public class Aplicacion {

    Scanner scanner = new Scanner(System.in);
    ListaClientes usuarios = new ListaClientes();


    public void bienvenida(){
            System.out.println("*************************************");
            System.out.println("*     Bienvenido a Alke Wallet      *");
            System.out.println("*  Tu solución digital financiera   *");
            System.out.println("*************************************");
        }

        public void menuInicioApp(){
            int opcion;
            byte salir;
            Cliente cliente=new Cliente();
            ListaClientes listaClientes = new ListaClientes();

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
                System.out.println("SALIR:  1.NO     2.SI");
                salir= scanner.nextByte();
            }while(salir==2);
        }

    public Cliente ingresoCuenta(){
        String correoCliente, contrasenaCliente;
        Cliente cliente;
        System.out.println("Ingrese correo electrónico");
        correoCliente = scanner.next();
        System.out.println("Ingrese contraseña");
        contrasenaCliente=scanner.next();
        boolean valido = false;
        for (int i=0; i<usuarios.getListaUsuarios().size(); i++){
            if(correoCliente.equals(usuarios.getListaUsuarios().get(i).getCorreoElectronico()) &&
                    contrasenaCliente.equals(usuarios.getListaUsuarios().get(i).getContrasena())) {
                    cliente = usuarios.getListaUsuarios().get(i);
                    return cliente;
            }else{
                System.out.println("correo electrónico o contraseña no es válido");
            }
        }
        return null;
    }

    public void menuCuentaUsuario(){
        int opcion;
        byte salir;
        boolean valido = false;
        do {
            try {
                System.out.println("    1. Ver mis datos");
                System.out.println("    2. Ver datos de mi cuenta");
                System.out.println("    Selecciona una opción");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion){
                    case 1:
                        int cont = 0;
                        while(cont<=3 && valido == false) {
                            if (ingresoCuenta() == null) {
                                ingresoCuenta();
                            } else {
                                valido= true;
                            }
                        }

                        if(valido ==true){

                        }

                        break;
                    case 2:

                        break;
                }
            }catch(Exception e) {
                System.out.println("Error " + e.getMessage());
            }
            System.out.println("SALIR:  1.NO     2.SI");
            salir= scanner.nextByte();
        }while(salir==2);
    }


}
