package ExamenParcial.Kevin.Ruiz.Sanchez.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Alumno")
public class AlumnoModel {
    
    @Id
    @Column(name = "idAlumno")
    public Integer idAlumno;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "nota")
    public BigDecimal  nota;
}
