
package Models;
import Consola.Consola;
/**
 *
 * @author pc
 */
public class Racional {
    private int num;
    private int den;

    public Racional() {
    }

    public Racional(int num, int den) {
        this.num = num;
        this.den = den;
    }
    
    public void cargarRacional(){
        ingresarNumerador();
        ingresarDenominador();
    }
    private void ingresarNumerador(){
         Consola.emitirMensajeLN("ingrese el numerador");
         this.num = Consola.leerInt();
    }
    private void ingresarDenominador(){
       int den;
       do{
           Consola.emitirMensajeLN("ingresar el denominador");
           den = Consola.leerInt();
           if(!validarDenominador(den)){
               Consola.emitirMensajeLN("denominador no pude ser 0");
           }
       }while(!validarDenominador(den));
       setDen(den);
    }
    private boolean validarDenominador(int den){
        return den != 0;
    }
    public static Racional multiplicar(Racional r1,Racional r2){
        int nuevoNum = r1.getNum() * r2.getNum();
        int nuevoDen = r1.getDen() * r2.getDen();
        
        Racional result = new Racional(nuevoNum,nuevoDen);
        
        return result;
    }
  
    
    public static Racional dividir(Racional r1,Racional r2){
        int nuevoNum = r1.getNum() * r2.getDen();
        int nuevoDen = r1.getDen() * r2.getNum();
        
        Racional resul = new Racional(nuevoNum,nuevoDen);
        
        return resul;
    }
    
    
    
    public int getNum() {
        return num;
    }

    private void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    private void setDen(int den) {
        this.den = den;
    }

    @Override
    public String toString() {
        return num+"/"+den;
    }
    
    
}
