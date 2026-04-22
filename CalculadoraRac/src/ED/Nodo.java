
package ED;


public class Nodo<T> {
       private T dato;
    private Nodo<T> ps;
    
     public Nodo() {
        this.ps = null;
    }
     
    public Nodo(T e){
        dato=e;
        ps=null;
                       }

    public T getDato() {
        return dato;
    }

    private void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getPs() {
        return ps;
    }

    private void setPs(Nodo<T> ps) {
        this.ps = ps;
    }
    public void enlazar(Nodo<T> ref){
        setPs(ref);
    }
}
