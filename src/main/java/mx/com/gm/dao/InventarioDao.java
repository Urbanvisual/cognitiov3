
package mx.com.gm.dao;

import mx.com.gm.domain.Inventario;
import org.springframework.data.repository.CrudRepository;


public interface InventarioDao extends CrudRepository<Inventario, Long> {
    
}
