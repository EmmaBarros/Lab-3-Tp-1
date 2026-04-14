
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Auto extends Vehiculo{
    private static int contadorId = 0;
    private int idAuto;

    public Auto() {
     super();
     contadorId ++;
     this.idAuto = contadorId;
    }

    public Auto(int idAuto, String modelo, String marca, int anio, int estado) {
        super(modelo, marca, anio, estado);
        contadorId ++;
        this.idAuto = contadorId;
    }
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        Consola.emitirMensajeLN("ID asignado al auto"+this.idAuto);
    }

    public static int getContadorId() {
        return contadorId;
    }

    private static void setContadorId(int contadorId) {
        Auto.contadorId = contadorId;
    }

    public int getIdAuto() {
        return idAuto;
    }

    private void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }
  @Override
    public String toString() {
        return "ID: " + idAuto + " | " + super.toString();
    }  
    @Override
    public boolean equals(Object obj) {
        // 1. Si son el mismo objeto en memoria, son iguales
        if (this == obj) {
            return true;
        }
        
        // 2. Si el otro objeto es nulo o de otra clase, no son iguales
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // 3. Casteamos el objeto a Auto para poder comparar el ID
        final Auto other = (Auto) obj;
        
        // Comparamos los IDs únicos
        return this.idAuto == other.idAuto;
    }
    
    
}
