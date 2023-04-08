
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Clase;

public interface ClaseService {
    public List<Clase> listarClases ();
    
    public void guardar(Clase clase);
    public void eliminar(Clase clase);
    public Clase encontrarClase(Clase clase);
    
}
