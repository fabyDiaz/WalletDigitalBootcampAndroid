package cl.walletDigital.clases;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {

        private List<Cliente> listaClientes = new ArrayList();
        public ListaClientes() {
            this.listaClientes.add(new Cliente(789456132,"Homero","Simpson","123648965-6","homero@correo.cl","+56963268745", "Homero123",new Cuenta()));

            //Agregar más clientes

        }
        public List<Cliente> getListaClientes() {
            return this.listaClientes;
        }

        public void  addCliente(Cliente cliente){
            listaClientes.add(cliente);
        }

        public Cliente validarRutCliente(String correo, String contrasena){
            for(Cliente cliente : listaClientes){
                if (correo.equals(cliente.getCorreoElectronico()) && cliente.validarContrasena(contrasena)) {
                    return cliente;
                }
            }
            return null;
        }



    @Override
    public String toString() {
        return "ListaUsuarios{" +
                "listausuarios=" + listaClientes +
                '}';
    }
}
