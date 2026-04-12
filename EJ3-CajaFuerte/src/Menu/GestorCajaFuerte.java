
package Menu;
import Models.CajaFuerte;
import Consola.Consola;
import Menu.Menu;
/**
 *
 * @author emami
 */
public class GestorCajaFuerte {
    private Menu menu;
    private CajaFuerte miCaja;

    public GestorCajaFuerte() {
    this.menu = new Menu("Sistema De Seguridad - Caja Fuerte");
    menu.agregarItem("Abrir Caja");
    menu.agregarItem("Cerrar Caja");
    menu.agregarItem("Cambiar Combinacion");
    this.miCaja = new CajaFuerte();
    if(!miCaja.isCargada()){
        miCaja.cargarCajaFuerte();
    }
    }
    public void iniciar (){
        int op;
        do{
            String estado;
            if (miCaja.isAbierta()){
               estado = "Abierta";
            }else{
               estado = "Cerrada";
            }
            Consola.emitirMensajeLN("Estado Actual"+estado);
            op = menu.ejecutar();
            switch(op){
                case 1:
                    miCaja.abrir();
                break;
                case 2:
                    miCaja.cerrar();
                    Consola.emitirMensajeLN("la caja a sido Cerrada");
                break;
                case 3:
                    miCaja.cambiarClave();
                break;
                default:
                    Consola.emitirMensajeLN("Opcion invalida");
                    break;
            }
            if(op!=0){
                Consola.emitirMensajeLN("presione enter para continuar...");
                Consola.leerDato();
            }
        }while(op!=0);    }
    
    
}
