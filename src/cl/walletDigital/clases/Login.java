package cl.walletDigital.clases;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    private String emailCliente;
    private String contrasena;

    public Login() {
    }

    public Login(String emailCliente, String contrasena) {
        this.emailCliente = emailCliente;
        this.contrasena = contrasena;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        emailCliente = emailCliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean validarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public String valiarEmail(String email) {
        // Patrón para validar el email
        Matcher mather;
        do{
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            mather= pattern.matcher(email);

            if(mather.find()==true){
                return email;
            }else{
                System.out.println("Correo no es válido");
            }

        }while (mather.find()==false);

        return null;
    }

    public Login CrearCorreoyContrasena(){
        Scanner scanner = new Scanner(System.in);
        String email, c;
        System.out.println("EMAIL:");
        email=scanner.nextLine();
        System.out.println("CREA UNA CONTRASEÑA");
        c=scanner.nextLine();
       return new Login(valiarEmail(email),c);
    }

    public Login prueba(){
        return new Login("email@correo.cl","123");
    }
    @Override
    public String toString() {
        return "Login{" +
                "EmailCliente='" + emailCliente + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
