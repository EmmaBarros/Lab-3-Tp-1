
package Models;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class CajaFuerte {
   private int n1,n2,n3; 
   private boolean abierta;
   private boolean cargada;

    public CajaFuerte(int n1, int n2, int n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.abierta = false;
        this.cargada = true;
    }

    public CajaFuerte() {
        this.abierta = false;
    }
   

 public void cargarCajaFuerte(){
     if(this.cargada){
         Consola.emitirMensajeLN("la caja ya esta cargada");
         Consola.emitirMensajeLN("use la opcion de cambiar combinacion desde el menu");
         return;
     }
     Consola.emitirMensajeLN("-Carga incial de la Caja");
     ingresarCombinacion();
     this.cargada = true;
     Consola.emitirMensajeLN("-Caja Cargada : *** ");
 }  
   
   
   public void abrir(){
       if(this.abierta){
           Consola.emitirMensajeLN("la caja ya se encuentra abierta");
           return;
       }
       
       Consola.emitirMensajeLN("Ingrese la Combinacion para Abrir la Caja");
       Consola.emitirMensajeLN(" - : ****");
       Consola.emitirMensajeLN("N1:");
       int c1 = Consola.leerInt();
       Consola.emitirMensajeLN("N2:");
       int c2 = Consola.leerInt();
       Consola.emitirMensajeLN("N3:");
       int c3 = Consola.leerInt();
       if(c1 == n1 && c2 == n2 && c3 == n3){
           Consola.emitirMensajeLN("Caja Abierta con Exito");
           this.abierta = true;
       }else{
           Consola.emitirMensajeLN("combinacion incorrecta");
       }
       
   }
   public void cambiarClave(){
       if(!isCargada()){
           Consola.emitirMensajeLN("la caja aun no a sido cargada,debera cargar la caja");
           return;
       }
       int a1,a2,a3;
       boolean claveCorrecta = false;
      do{ 
       Consola.emitirMensajeLN("-Cambio de Clave");
       Consola.emitirMensajeLN("ingrese la clave para verificar");
       Consola.emitirMensajeLN("N1 = "); 
       a1 = Consola.leerInt();
       Consola.emitirMensajeLN("N2 = ");
       a2 = Consola.leerInt();
       Consola.emitirMensajeLN("N3 = ");
       a3 = Consola.leerInt();
       if(a1 == n1 && a2 == n2 && a3 == n3){
           claveCorrecta = true;
           Consola.emitirMensajeLN("verificacion exitosa");
           Consola.emitirMensajeLN("-ingrese la nueva clave:");
           ingresarCombinacion();
           Consola.emitirMensajeLN("Combinacion cambiada!");
       }else{
           Consola.emitirMensajeLN("Clave incorrecta...");
           Consola.emitirMensajeLN("intente nu");
       }
      }while(!claveCorrecta); 
     
   }
   private void ingresarCombinacion(){
       int temp1,temp2,temp3;
       Consola.emitirMensajeLN("ingrese el primer numero:");
       temp1 = Consola.leerInt();
       Consola.emitirMensajeLN("ingrese el segundo numero:");
       temp2 = Consola.leerInt();
       Consola.emitirMensajeLN("ingrese el tercer numero:");
       temp3 = Consola.leerInt();
       
       setN1(temp1);
       setN2(temp2);
       setN3(temp3);
   }
   public void cerrar(){
       this.abierta = false;
   }
    public int getN1() {
        return n1;
    }

    private void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    private void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    private void setN3(int n3) {
        this.n3 = n3;
    }

    public boolean isAbierta() {
        return abierta;
    }
    public boolean isCargada(){
        return cargada ;
    }

    private void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
   
   
}
