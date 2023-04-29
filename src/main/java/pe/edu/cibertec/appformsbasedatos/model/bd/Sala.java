package pe.edu.cibertec.appformsbasedatos.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sala")
@Getter
@Setter
@NoArgsConstructor
public class Sala {
    @Id
    private Integer idsala;
    @Column(name = "descsala")
    private String descsala;
    @Column(name = "asientos")
    private Integer asientos;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idestado")
    private Estado estado;

}
