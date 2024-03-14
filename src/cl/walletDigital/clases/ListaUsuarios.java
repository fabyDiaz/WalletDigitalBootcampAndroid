package cl.walletDigital.clases;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {

        private List<Usuario> listausuarios = new ArrayList();
        public ListaUsuarios() {
            this.listausuarios.add(new Usuario("Homero","Simpson","12345789-6",789654123, 1234));

            //Agregar el resto de los usuarios

        }
        public List<Usuario> getListaUsuarios() {
            return this.listausuarios;
        }

    @Override
    public String toString() {
        return "ListaUsuarios{" +
                "listausuarios=" + listausuarios +
                '}';
    }
}
