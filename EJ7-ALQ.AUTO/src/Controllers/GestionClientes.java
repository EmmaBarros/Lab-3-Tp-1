
package Controllers;

import ED.ListaEncadenada;
import ED.Nodo;
import Models.Auto;
import Models.Cliente;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class GestionClientes {
    private ListaEncadenada<Cliente> listaClientes;

    public GestionClientes() {
    this.listaClientes = new ListaEncadenada<>();
    }
    
    public void registrarClientes(){
        Cliente nuevoCl = new Cliente();
        nuevoCl.CargarDatos();
        listaClientes.insertarPri(nuevoCl);
        Consola.emitirMensajeLN("Cliente Registrado");    
    }
    public void mostrarClientes(){
        Consola.emitirMensajeLN("Clientes");
        Nodo<Cliente> p = listaClientes.inicio();
        if(p==null){
            Consola.emitirMensajeLN("no hay clientes registrados...");
            return;
        }
        while(p!=null){
            Cliente c = p.getDato();
            Consola.emitirMensajeLN("-----------");
            Consola.emitirMensajeLN(c.toString());
            if(c.getAutosAlquilados().listaVacia()){
                Consola.emitirMensajeLN("- no tiene autos alquilados");
            }else{
                Consola.emitirMensajeLN("- Atuos alquilados");
                Nodo<Auto> pAuto = c.getAutosAlquilados().inicio();
                while(pAuto!=null){
                    Consola.emitirMensajeLN("-"+pAuto.getDato().toString());
                    pAuto = pAuto.getPs();
                }
            }
            p = p.getPs();
        }
    }
    
    public Cliente buscarClPorId(int id){
        Nodo<Cliente> p = listaClientes.inicio();
        while(p!=null){
            if (p.getDato().getIdCliente()==id) {
                return p.getDato();
            }
            p=p.getPs();
        }
        return null;
    }
    
}
