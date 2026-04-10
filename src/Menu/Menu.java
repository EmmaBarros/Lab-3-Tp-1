
package Menu;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Menu {
    private String Titulo;
    private String[] items;
    private int cv;
    private final int Max = 10;

    public Menu(String Titulo) {
        this.Titulo = Titulo;
        this.items = new String[Max];
        this.cv = 0;
    }
    
    public void agregarItem(String texto){
            if(cv < Max){
                items[cv] = texto;
            }else{
                Consola.emitirMensajeLN("no se pueden ingresar mas opciones");
            }
    }
    public void removerItem(String texto){
        for (int i = 0; i < cv; i++) {
            if(items[i].equals(texto)){
                for (int j = 0; j < cv; j++) {
                    items[j]=items[j+1];
                }
                items[cv-1]=null;
                cv --;
                Consola.emitirMensajeLN("elemento eliminado");
                return;
            }
        }
    }    
    public void actualizarItem(String viejo,String nuevo){
        for (int i = 0; i < cv; i++) {
            if(items[i].equals(viejo)){
                items[i] = nuevo;
                return;
            }
        }
    }
  
    public void mostrarMenu(){
        Consola.emitirMensajeLN("\n--"+ Titulo +"--");
      if(cv == 0){
          Consola.emitirMensajeLN("el menu esta vacio!");
      }else{
          for (int i = 0; i < cv; i++) {
              Consola.emitirMensajeLN((i+1)+"."+items[i]);
          }
      }
     Consola.emitirMensajeLN("presione (0) para salir o volver...");
     Consola.emitirMensajeLN("Seleccione una opcion");
    }
    public int ejecutar(){
        int op ;
      do{
         mostrarMenu();
         op = Consola.leerInt();
         if(op < 0 || op > cv){
             Consola.emitirMensajeLN("opcion fuera del rango de posibilidades");
             op = -1;
         }
      }while(op == -1);
      return op;
    }
    
}
