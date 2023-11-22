package pe.cibertec.ProyectoFinal.ApiTurno.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiTurno.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiTurno.service.TurnoService;

@RestController
@RequestMapping("api/v1/turno")

public class TurnoController {
    
    @Autowired
    
    private TurnoService turnoService;
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Turno>> findAll() {
        
        return new ResponseEntity<>(turnoService.findAll(), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByNombre/{nombre}")
    
    public ResponseEntity<Turno> findByNombre(@PathVariable String nombre) {
        
        return new ResponseEntity<>(turnoService.findByNombre(nombre), HttpStatus.OK);
        
    }
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(turnoService.buscarPorId(id), HttpStatus.OK);
        
    } 
    
    @PostMapping ("/agregarTurno")
    
    public ResponseEntity<Turno> agregarTurno(@RequestBody Turno turno) {
        
        return new ResponseEntity<>(turnoService.agregarTurno(turno), HttpStatus.CREATED);
        
    }
    
    @PutMapping ("/actualizarTurno")
    
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        
        return new ResponseEntity<>(turnoService.actualizarTurno(turno), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarTurno/{id}")
    
    public void eliminarTurno (@PathVariable Long id) {
        
        turnoService.eliminarTurno(id);
        
    }
    
}
