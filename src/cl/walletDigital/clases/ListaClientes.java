package cl.walletDigital.clases;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {

        private List<Cliente> listaClientes = new ArrayList();
        public ListaClientes() {
            this.listaClientes.add(new Cliente(1,"Homero","Simpson","123648965-6","+56963268745", new CuentaBancaria(),new Login("homero@correo.cl","homero123")));

            //Agregar más clientes

        }
        public List<Cliente> getListaClientes() {
            return this.listaClientes;
        }

        public void  addCliente(Cliente cliente){
            listaClientes.add(cliente);
        }



    @Override
    public String toString() {
        return "ListaUsuarios{" +
                "listausuarios=" + listaClientes +
                '}';
    }
}
