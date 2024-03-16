package cl.walletDigital.clases;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {

        private List<Cliente> listausuarios = new ArrayList();
        public ListaUsuarios() {
            this.listausuarios.add(new Cliente(789456132,"123648965-6","Homero","Simpson","homero@correo.cl","+56963268745",new Cuenta()));

            //Agregar el resto de los usuarios

        }
        public List<Cliente> getListaUsuarios() {
            return this.listausuarios;
        }

    @Override
    public String toString() {
        return "ListaUsuarios{" +
                "listausuarios=" + listausuarios +
                '}';
    }
}
