
package Controllers;
import Models.Auto;
import Models.Cliente;
import Menu.Menu;
import ED.Nodo;
import Consola.Consola;
/**
 *esta clase actuara como controlador principal 
 * vinculando la gestion de autos con gestion clientes
 * que utilizaran la listas de cada respectiva clase(lista de autos y lista de Clientes)
 *, gestionando la interaccion del usuario con la clase Menu 
 * 
 *
 * @author emami
 */
public class GestionAlquiler {
    private GestionAutos gAutos;
    private GestionClientes gClientes;
    private Menu menu;

    public GestionAlquiler() {
    this.gAutos = new GestionAutos();
    this.gClientes = new GestionClientes();
     
    this.menu = new Menu("Sistema Gestion Alquiler");
    menu.agregarItem("Agregar vehiculo");
    menu.agregarItem("Registrar nuevo Cliente");
    menu.agregarItem("ver Autos disponibles");
    menu.agregarItem("Alquilar un Vehiculo a un Cliente");
    menu.agregarItem("devolver Vehiculo");
    menu.agregarItem("Listar Clientes");
    }
    
    
/**metodo principal recorre el programa en funcion del menu con 
*un bucle hasta que el usuario lo termine
*
*/
    public void iniciar(){
        int op;
        do{
            op = menu.ejecutar();
          switch(op){
              case 1:
                  gAutos.agregarVehiculo();
                  break;
              case 2:
                  gClientes.registrarClientes();
                  break;
              case 3:
                  gAutos.mostrarDisponibles();
                  break;
              case 4:
                  alquiler();
                  break;
              case 5:
                  devolucion();
                  break;
              case 6:
                  gClientes.mostrarClientes();
                  break;
              case 0:
                  Consola.emitirMensajeLN("saliendo del sistema");
                  break;
              default: Consola.emitirMensajeLN("opcion no valida");
          }
        }while(op!=0);
    }
    
    
   private void alquiler(){
        //este metodo vinculara un auto con un cliente registrado
        Consola.emitirMensajeLN("-Alquiler de Auto");
        //se muestran los autos disponibles y se selecciona uno
        gAutos.mostrarDisponibles();
        Consola.emitirMensajeLN("ingrese el id del vehiculo a alquilar");
        int idA = Consola.leerInt();
        Auto a = gAutos.buscarPorId(idA);
        
        //se verifica que el auto exista (a != null) , y que no este alquilado
        if(a != null && a.getEstado() ==1 ){
            //se busca el cliente que realizara el alquiler
            gClientes.mostrarClientes();
            Consola.emitirMensajeLN("ingrese el id del Cliente");
            int idC = Consola.leerInt();
            Cliente c = gClientes.buscarClPorId(idC);
           
           if(c != null){//se verifica que el cliente exita
               //cambiamos el estado a alquilado = 2
               a.actualizarEstado(2);
               //agregamos a la lista personal del cliente
               c.getAutosAlquilados().insertarPri(a);
               Consola.emitirMensajeLN("vehiculo"+idA+"asignado a "+c.getApe());              
           }else{
               Consola.emitirMensajeLN("cliente no encontrado");
           }        
        }else{
            Consola.emitirMensajeLN("vehiculo no disponible o id invalido");
        }
        
    
    }
   
   
   private void devolucion(){
       Consola.emitirMensajeLN("Proceso de Devolucion");
       Consola.emitirMensajeLN("ignrese un id de cliente que devuelve");
       int idC = Consola.leerInt();
       Cliente c = gClientes.buscarClPorId(idC);
       
       if(c != null){//se busca y verifica que tiene autos alquilados
           if(c.getAutosAlquilados().listaVacia()){
               Consola.emitirMensajeLN("el cliente no posee autos alquilados");
               return ;
           }
           //se muestran los autos alquilados para que luego elija 
           Consola.emitirMensajeLN("Vehiculos alquilados de "+c.getNom());
           Nodo<Auto> p = c.getAutosAlquilados().inicio();
           while(p!=null){
               Consola.emitirMensajeLN("-"+p.getDato().toString());
               p = p.getPs();
           }
           Consola.emitirMensajeLN("ingrese el id del auto a devolver:");
           int idA = Consola.leerInt();
           Auto a = gAutos.buscarPorId(idA);
           if(a!=null){//se procede a eliminar y actualizar 
               if(c.getAutosAlquilados().eliminar(a)!= null ){//primero se busca en la lista de autos
              // y luego se elimina si es != null , buscando primero en la lista clientes y si lo encuentra lo borra                 
                   a.actualizarEstado(1);//se cambia el estado
                   Consola.emitirMensajeLN("El vehiculo a regresado a la flota");
               }else{
                   Consola.emitirMensajeLN("el vehiculo no pertenece al cliente");
               }
           }else{
               Consola.emitirMensajeLN("id de vehiculo no registrado");
           }
       }else{
           Consola.emitirMensajeLN("cliente no encontrado");
       }
       
   }
}
    

