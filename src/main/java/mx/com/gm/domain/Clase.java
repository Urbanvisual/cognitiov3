package mx.com.gm.domain;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clase")
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclase;

    @NotEmpty
    private String nomclase;

    @NotEmpty
    private String fechareserva;

       
    private String nominstructor;

    
    

}
