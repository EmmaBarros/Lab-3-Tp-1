
package Models;
import Consola.Consola;
import Menu.Menu;
/**
 *
 * @author pc
 */
public class GestorCalculadora {
    private Menu menu;
    public GestorCalculadora() {
    this.menu = new Menu("--Calculadora Racional--");
    menu.agregarItem("Multiplicar");
    menu.agregarItem("Dividir");
    }
  public void iniciar(){
      int op;
      Racional r1,r2,resul;
      do{
          op = menu.ejecutar();
          switch(op){
              case 1:
                   r1 = new Racional();
                  Consola.emitirMensajeLN("Primer Racional");
                  r1.cargarRacional();
                  
                   r2 = new Racional();
                  Consola.emitirMensajeLN("Segundo Racional");
                  r2.cargarRacional();
                   
                 
                 resul = Racional.multiplicar(r1, r2);
                 Consola.emitirMensajeLN("Resultado de la Multiplicacion ");
                 Consola.emitirMensajeLN(r1.toString()+" X "+r2.toString()+" = "+resul);
               break;
               
              case 2:
                     r1 = new Racional();
                  Consola.emitirMensajeLN("Primer Racional");
                  r1.cargarRacional();
                  
                     r2 = new Racional();
                  Consola.emitirMensajeLN("Segundo Racional");
                  r2    .cargarRacional();
                   
               
                  resul = Racional.dividir(r1, r2);
                  Consola.emitirMensajeLN("Resultado de la Division ");
                 Consola.emitirMensajeLN(r1.toString()+" | "+r2.toString()+" =  "+resul);
                 break;
              case 0:
                  Consola.emitirMensajeLN("Cerrando la calculadora...");
                  break;
          }
          if(op!=0){
              Consola.emitirMensajeLN("presione s/n para continuar");
              Consola.leerDato();
          }
      }while(op!=0);
  }  
}
