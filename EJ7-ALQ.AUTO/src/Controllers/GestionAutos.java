
package Controllers;
import ED.ListaEncadenada;
import ED.Nodo;
import Models.Auto;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class GestionAutos {
    private ListaEncadenada<Auto> listAut;

    public GestionAutos() {
        listAut = new ListaEncadenada<>();
    }
    
public void agregarVehiculo(){
    Auto nuevoAuto = new Auto();
    nuevoAuto.cargarDatos();
     listAut.insertarPri(nuevoAuto);
     Consola.emitirMensajeLN("Vehiculo agregado a la lista");
}

public void mostrarDisponibles(){
    Consola.emitirMensajeLN("Lista de Vehiculos disponibles:");
    if (listAut.listaVacia()) {
        Consola.emitirMensajeLN("la lista de autos esta vacia...");
        return;
    }
    boolean disp = false;
    Nodo<Auto> p = listAut.inicio();
    while(p!=null){
        Auto autoActual = p.getDato();
        if (autoActual.getEstado()== 1) {//si el auto esta disponible
            Consola.emitirMensajeLN(autoActual.toString());
            disp = true;
        }
        p = p.getPs();
    }
    if(!disp){
        Consola.emitirMensajeLN("No hay Autos disponibles...");
    }
}

public Auto buscarPorId(int id){
    Nodo<Auto> p = listAut.inicio();
    while(p!= null){
        Auto autoActual = p.getDato();
        if (autoActual.getIdAuto() == id) {
            return autoActual;
        }
    }
    return null;
}
    
}
