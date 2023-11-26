package pe.cibertec.ProyectoFinal.ApiTurno.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
import pe.cibertec.ProyectoFinal.ApiTurno.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiTurno.service.TurnoService;

@RestController
@RequestMapping("api/v1/turno")
@Slf4j

public class TurnoController {

    @Autowired

    private TurnoService turnoService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Turno>> findAll() {

        try {
            log.info("Endpoint: /api/v1/turno/findAll - Buscando todos los turnos");
            List<Turno> turnos = turnoService.findAll();
            return new ResponseEntity<>(turnos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error en buscar todos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByNombre/{nombreH}")

    public ResponseEntity<Turno> findByNombreH(@PathVariable String nombreH) {

        try {
            log.info("Endpoint: /api/v1/turno/findByNombre/{} - Buscando turno por nombre: {}", nombreH, nombreH);
            Turno turno = turnoService.findByNombreH(nombreH);
            return new ResponseEntity<>(turno, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar turno por nombre {}: {}", nombreH, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Endpoint: /api/v1/turno/buscarPorId/{} - Buscando turno por ID: {}", id, id);
            Turno turno = turnoService.buscarPorId(id);
            return new ResponseEntity<>(turno, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar turno por ID : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/agregarTurno")

    public ResponseEntity<Turno> agregarTurno(@RequestBody Turno turno) {

        try {
            log.info("Endpoint: /api/v1/turno/agregarTurno - Agregando nuevo turno: {}", turno);
            Turno nuevoTurno = turnoService.agregarTurno(turno);
            return new ResponseEntity<>(nuevoTurno, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error en la operación: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizarTurno")

    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {

        try {
            log.info("Endpoint: /api/v1/turno/actualizarTurno - Actualizando turno con ID {}: {}", turno.getId(), turno);
            Turno turnoActualizado = turnoService.actualizarTurno(turno);
            return new ResponseEntity<>(turnoActualizado, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al actualizar turno con ID {}: {}", turno.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminarTurno/{id}")

    public void eliminarTurno(@PathVariable Long id) {

        try {

            log.info("Endpoint: /api/v1/turno/eliminarTurno/{} - Eliminando turno con ID: {}", id, id);
            turnoService.eliminarTurno(id);
        } catch (Exception e) {

            log.error("Error al eliminarTurno con el ID {} : {}", e.getMessage());

        }

    }

}
