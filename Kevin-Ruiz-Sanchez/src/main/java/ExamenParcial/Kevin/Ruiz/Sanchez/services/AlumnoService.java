package ExamenParcial.Kevin.Ruiz.Sanchez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenParcial.Kevin.Ruiz.Sanchez.exception.ResourceNotFoundException;
import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;
import ExamenParcial.Kevin.Ruiz.Sanchez.repository.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    IAlumnoRepository repository;

    @Override
    public List<AlumnoModel> findAll() {
        try {
            return (List<AlumnoModel>) repository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener todos los alumnos: " + ex.getMessage());
        }
    }

    @Override
    public AlumnoModel findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El alumno con ID " + id + " no fue encontrado"));
    }

    @Override
    public AlumnoModel add(AlumnoModel model) {
        try {
            return repository.save(model);
        } catch (Exception ex) {
            throw new RuntimeException("Error al guardar el alumno: " + ex.getMessage());
        }
    }

    @Override
    public AlumnoModel update(AlumnoModel model) {
        if (!repository.existsById(model.idAlumno)) {
            throw new ResourceNotFoundException("El alumno con ID " + model.idAlumno + " no existe para actualizar");
        }
        try {
            return repository.save(model);
        } catch (Exception ex) {
            throw new RuntimeException("Error al actualizar el alumno: " + ex.getMessage());
        }
    }

    @Override
    public Boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("El alumno con ID " + id + " no existe para eliminar");
        }
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Error al eliminar el alumno: " + ex.getMessage());
        }
    }
}