package ExamenParcial.Kevin.Ruiz.Sanchez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;
import ExamenParcial.Kevin.Ruiz.Sanchez.services.AlumnoService;
import ExamenParcial.Kevin.Ruiz.Sanchez.config.ApiRoutes;

@RestController
@RequestMapping(ApiRoutes.API_ALUMNO)
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(ApiRoutes.FIND_ALL)
    public List<AlumnoModel> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping(ApiRoutes.GET_BY_ID)
    public AlumnoModel getById(@RequestParam("id") Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping(ApiRoutes.CREATE)
    public AlumnoModel create(@RequestBody AlumnoModel model) {
        return alumnoService.add(model);
    }

    @PutMapping(ApiRoutes.UPDATE)
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        return alumnoService.update(model);
    }

    @DeleteMapping(ApiRoutes.DELETE)
    public boolean delete(@RequestParam("id") Integer id) {
        return alumnoService.delete(id);
    }
}
