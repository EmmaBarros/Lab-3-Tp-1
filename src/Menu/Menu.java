
package Menu;
import ED.Nodo;
import ED.ListaEncadenada;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Menu {
    private String Titulo;
    private ListaEncadenada <String> items;

    public Menu(String Titulo) {
        this.Titulo = Titulo;
        this.items = new ListaEncadenada<>();
    }
    
    public void agregarItem(String opcion){
        items.insertarPri(opcion);
    }
    public void removerItem(String opcion){
        items.eliminar(opcion);
    }    
    public void actualizarItem(String viejo,String nuevo){
        Nodo<String> p = items.inicio();
        while(p!=null){
            if(p.getDato().equals(viejo)){
                items.eliminar(viejo);
                items.insertarPri(nuevo);
            }
            p = p.getPs();
        }
    }
    private int obtenerRango(){
        int cont = 0;
        Nodo<String> p = items.inicio();
        while(p!=null){
            cont ++;
            p = p.getPs();
        }
       return cont;
    }
    public void MostrarMenu(){
        Consola.emitirMensajeLN("\n--"+ Titulo +"--");
       Nodo<String> p = items.inicio();
       int i = 1;
       if(items.listaVacia()){
        Consola.emitirMensajeLN("El menu esta vacio");
    }else{
           while(p!=null){
               Consola.emitirMensajeLN(i+"."+p.getDato());
               p = p.getPs();
               i ++;
           }
       }
     Consola.emitirMensajeLN("presione (0) para salir o volver...");
     Consola.emitirMensajeLN("Seleccione una opcion");
    }
    public int ejecutar(){
        int op ;
        int max = obtenerRango();
        do{
           MostrarMenu();
           op = Consola.leerInt();
           if(op < 0 || op > max){
               Consola.emitirMensajeLN("opcion incorrecta (rango invalido)");
               op = -1;
           }
        }while(op == -1);
        return op;
    }
    
}
