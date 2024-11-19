package ExamenParcial.Kevin.Ruiz.Sanchez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExamenParcial.Kevin.Ruiz.Sanchez.model.AlumnoModel;
import ExamenParcial.Kevin.Ruiz.Sanchez.services.AlumnoService;

@RestController
@RequestMapping("Alumno")
public class AlumnoController {
    
     @Autowired
    AlumnoService alumnoService;

    @GetMapping("/findAll")
    public List<AlumnoModel> FindAll(){
        List<AlumnoModel> lista = alumnoService.findAll();
        return lista;
    }

    @GetMapping("/getById")
    public AlumnoModel getById(int id) {
        return alumnoService.findById(id);
    }

    @PostMapping("/create")
    public AlumnoModel create(@RequestBody AlumnoModel model){   
        return alumnoService.add(model);
    }

    @PutMapping("/update")
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        return alumnoService.update(model);
    }

    @DeleteMapping("/delete")
    public boolean delete(int id) {
        return alumnoService.delete(id);
    }

}