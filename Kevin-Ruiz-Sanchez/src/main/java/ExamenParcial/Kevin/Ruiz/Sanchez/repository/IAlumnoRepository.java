package ExamenParcial.Kevin.Ruiz.Sanchez.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;

@Repository
public interface IAlumnoRepository extends CrudRepository<AlumnoModel, Integer>{
    
}
