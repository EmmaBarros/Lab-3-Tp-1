
package Models;
import ED.ListaEncadenada;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Cliente extends Persona {
    private static int contadorId = 0;
    private int idCliente;
    private ListaEncadenada autosAlquilados;

    public Cliente(int idCliente, ListaEncadenada autosAlquilados, String nom, String ape, String dni) {
        super(nom, ape, dni);
         contadorId ++;
        this.idCliente = contadorId;
        this.autosAlquilados = new ListaEncadenada();
    }
  
    public Cliente() {
        super();
        this.autosAlquilados = new ListaEncadenada();   
        contadorId ++;
        this.idCliente = contadorId;
    }
    @Override
    public void CargarDatos(){
        super.CargarDatos();
        Consola.emitirMensajeLN("ID asignado :"+ this.idCliente);
    }

    public int getContadorId() {
        return contadorId;
    }

    private void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public int getIdCliente() {
        return idCliente;
    }

    private void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ListaEncadenada getAutosAlquilados() {
        return autosAlquilados;
    }

    private void setAutosAlquilados(ListaEncadenada autosAlquilados) {
        this.autosAlquilados = autosAlquilados;
    }
    
    
}
