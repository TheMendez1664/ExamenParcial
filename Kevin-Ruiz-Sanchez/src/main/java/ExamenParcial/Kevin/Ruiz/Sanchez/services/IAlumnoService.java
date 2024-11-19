package ExamenParcial.Kevin.Ruiz.Sanchez.services;

import java.util.List;

import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;

public interface IAlumnoService {
    
    public List<AlumnoModel> findAll();
    public AlumnoModel findById(Integer id);
    public AlumnoModel add(AlumnoModel model);
    public AlumnoModel update(AlumnoModel model);
    public Boolean delete(Integer id);
}
