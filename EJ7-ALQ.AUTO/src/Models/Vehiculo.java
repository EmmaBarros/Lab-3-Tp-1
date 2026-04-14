
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Vehiculo {
 private String modelo;
 private String marca;
 private int anio;
 private int estado;//(1.disp 2.alquilado 3.en mantenimiento)

    public Vehiculo(String modelo, String marca, int anio, int estado) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.estado = estado;
    }

    public Vehiculo() {
        this.estado = 1;
    }
    public void cargarDatos(){
        ingresarModelo();
        ingresarMarca();
        ingresarAnio();
        ingresarEstado();
    }
    
    
    
    private void ingresarModelo(){
    String m;
    do{
        Consola.emitirMensajeLN("Modelo : ");
        m = Consola.leerDato();
        if (!validarString(m)) {
            Consola.emitirMensajeLN("carga de modelo invalida , intente nuevamente");
        }
    }while(!validarString(m));
    setModelo(m);
}
    private void ingresarMarca(){
       String m;
    do{
        Consola.emitirMensajeLN("Marca: ");
        m = Consola.leerDato();
        if (!validarString(m)) {
            Consola.emitirMensajeLN("carga de marca invalida , intente nuevamente");
        }
    }while(!validarString(m));
    setMarca(m);
        
    }
    private void ingresarAnio(){
        int a;
    do{
        Consola.emitirMensajeLN("Año : ");
        a = Consola.leerInt();
        if (!validarAnio(a)) {
            Consola.emitirMensajeLN("carga de año invalida (fuera de rango) , intente nuevamente");
            Consola.emitirMensajeLN("Rango 1970-2026");
        }
    }while(!validarAnio(a));
    setAnio(a);
    }
    private void ingresarEstado(){
        int e;
        do{
            Consola.emitirMensajeLN("ingresar Estado");
            Consola.emitirMensajeLN("1.Disponible | 2.Alquilado | 3.Mantenimiento");
            e = Consola.leerInt();
            if (!validarEstado(e)) {
                Consola.emitirMensajeLN("Opcion invalida , por favor seleccione una de las opciones");
            }
        }while(!validarEstado(e));
    }
    
    
    public void actualizarEstado(int nuevoEstado){
    int estadoAux = nuevoEstado;

    while(!validarEstado(estadoAux)){
        Consola.emitirMensajeLN("ingreso para el cambio incorrecto"+estadoAux+"no es un estado valido ");
        Consola.emitirMensajeLN("ingrese un estado valido 1.Disponible | 2.Alquilado | 3.Mantenimiento");
        estadoAux = Consola.leerInt();
    }
    this.setEstado(estadoAux);
    }
    
    private boolean validarString(String n){
         return n != null && !n.trim().isEmpty() ;
    }
    private boolean validarAnio(int x){
        return x >= 1970 && x <= 2026;
    }
    private boolean validarEstado(int x){
        return x == 1 || x == 2 || x == 3;
    }
    


    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    private void setAnio(int anio) {
        this.anio = anio;
    }


    public int getEstado() {
        return estado;
    }

    private void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String textoEstado = "";
        switch (estado) {
            case 1: textoEstado = "Disponible"; break;
            case 2: textoEstado = "Alquilado"; break;
            case 3: textoEstado = "En mantenimiento"; break;
        }
        return marca + " " + modelo + " (" + anio + ") - [" + textoEstado + "]";
    }
 
 
 
 
 
 
}
