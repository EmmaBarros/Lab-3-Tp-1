
package ED;

/**
 *
 * @author emami
 */
public class ListaEncadenada<T> {
     protected Nodo<T> list;

    public ListaEncadenada() {
        this.list = null;
    }

    public Nodo<T> inicio() {
        return list;
    }

    public boolean listaVacia() {
        return list == null;
    }

    public void insertarPri(T elem) {
        Nodo<T> x = new Nodo<>(elem);
       if(list == null){
           list = x;
       }else{
           x.enlazar(list);
           list = x;
       }
    }

   public Nodo<T> eliminar(T elem) {
        Nodo <T>x = null;
        Nodo <T>p = list;
        Nodo <T>ant = null;
        if(list == null)
            return x;
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().equals(elem)) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();

            }
        }
        if (band == true) {
            quitar(p, ant);
            x = p;
        }
        return x;
    }

    public Nodo<T> quitar(Nodo<T> p, Nodo<T> ant) {
        Nodo<T> x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.enlazar(p.getPs());
        }
        return x;
    }
}
