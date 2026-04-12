
package Menu;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class GestorMenu {
    private Menu menuUser;
    private Menu admin;

    public GestorMenu() {
        this.menuUser = new Menu("Menu de Usuario");
        this.admin = new Menu("Administrador de Opciones");


     
       admin.agregarItem("Agregar Opcion");
       admin.agregarItem("Editar Opcion");
       admin.agregarItem("Eliminar Opcion");
       admin.agregarItem("Prueba de menu");

    }
   public void iniciar(){
       int op;
       do{
       op = admin.ejecutar();
       procesar(op);
       
       }while(op!=0);
   } 
   public void procesar(int op){
    switch(op){
        case 1:
            do{
                Consola.emitirMensajeLN("ingrese la nueva opcion..");
                menuUser.agregarItem(Consola.leerDato());
                Consola.emitirMensajeLN("opcion agregada!");
            }while(Consola.confirmar());
            break;
        case 2:
            do{
                Consola.emitirMensajeLN("Ingrese nombre de la opcion a cambiar");
                String viejo = Consola.leerDato();
                Consola.emitirMensajeLN("nuevo nombre de opcion");
                String nuevo = Consola.leerDato();
                menuUser.actualizarItem(viejo, nuevo);
                Consola.emitirMensajeLN("opcion actualizada");
            }while(Consola.confirmar());
             break;
        case 3:
            do{
                Consola.emitirMensajeLN("Ingrese nombre de la oppcion a borrar");
                menuUser.removerItem(Consola.leerDato());
                Consola.emitirMensajeLN("eliminacion realizada");
            }while(Consola.confirmar());
            break;
        case 4:
            Consola.emitirMensajeLN("Prueba del Menu");
            int opc = menuUser.ejecutar();
            if(opc != 0){
                Consola.emitirMensajeLN("ejecutando opcion nro "+opc);
            }
            break ;
    }       
   } 
}
