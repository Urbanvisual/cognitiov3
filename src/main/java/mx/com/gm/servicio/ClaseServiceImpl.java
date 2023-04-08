package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ClaseDao;
import mx.com.gm.domain.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseDao claseDao;

    @Override
    @Transactional (readOnly = true)
    public List<Clase> listarClases() {
       return (List<Clase>)claseDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Clase clase) {
        claseDao.save(clase);
    }

    @Override
    @Transactional
    public void eliminar(Clase clase) {
        claseDao.delete(clase);
    }

    @Override
     @Transactional (readOnly = true)
    public Clase encontrarClase(Clase clase) {
      return  claseDao.findById(clase.getIdclase()).orElse(null);
    }

    

   
}
