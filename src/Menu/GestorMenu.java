
package Menu;

/**
 *
 * @author emami
 */
public class GestorMenu {
    private String Titulo;
    private ListaEncadenada<String> items;

    public GestorMenu(String Titulo) {
        this.Titulo = Titulo;
        this.items = new ListaEncadenada<>();
    }
    
    
}
