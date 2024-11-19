package ExamenParcial.Kevin.Ruiz.Sanchez.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenParcial.Kevin.Ruiz.Sanchez.exception.ResourceNotFoundException;
import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;
import ExamenParcial.Kevin.Ruiz.Sanchez.repository.IAlumnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService implements IAlumnoService {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);

    @Autowired
    IAlumnoRepository repository;

    @Override
    public List<AlumnoModel> findAll() {
        try {
            List<AlumnoModel> lista = (List<AlumnoModel>) repository.findAll();
            if (lista.isEmpty()) {
                throw new ResourceNotFoundException("No se encontraron alumnos");
            }
            return lista;
        } catch (Exception e) {
            logger.error("Error al obtener todos los alumnos: " + e.getMessage());
            throw new RuntimeException("Error al obtener todos los alumnos");
        }
    }

    @Override
    public AlumnoModel findById(Integer id) {
        try {
            Optional<AlumnoModel> alumno = repository.findById(id);
            if (alumno.isEmpty()) {
                throw new ResourceNotFoundException("Alumno no encontrado con ID: " + id);
            }
            return alumno.get();
        } catch (Exception e) {
            logger.error("Error al buscar el alumno con id {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al buscar el alumno");
        }
    }

    @Override
    public AlumnoModel add(AlumnoModel model) {
        try {
            return repository.save(model);
        } catch (Exception e) {
            logger.error("Error al agregar el alumno: " + e.getMessage());
            throw new RuntimeException("Error al agregar el alumno");
        }
    }

    @Override
    public AlumnoModel update(AlumnoModel model) {
        try {
            return repository.save(model);
        } catch (Exception e) {
            logger.error("Error al actualizar el alumno: " + e.getMessage());
            throw new RuntimeException("Error al actualizar el alumno");
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("Error al eliminar el alumno con id {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al eliminar el alumno");
        }
    }
}