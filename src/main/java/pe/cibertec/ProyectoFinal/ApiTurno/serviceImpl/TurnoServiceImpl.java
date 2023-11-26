package pe.cibertec.ProyectoFinal.ApiTurno.serviceImpl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiTurno.dao.TurnoRepository;
import pe.cibertec.ProyectoFinal.ApiTurno.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiTurno.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiTurno.service.TurnoService;

@Service
@Slf4j

public class TurnoServiceImpl implements TurnoService {

    @Autowired

    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> findAll() {

        log.info("Buscando todos los turnos");
        return (List<Turno>) turnoRepository.findAll();

    }

    @Override
    public Turno findByNombreH(String nombreH) {

        log.info("Buscando turno por nombre: {}", nombreH);
        return turnoRepository.findByNombreH(nombreH).orElseThrow(() -> new EntityNotFoundException("Turno no encontrado con el nombre " + nombreH));

    }

    @Override
    public Turno buscarPorId(Long id) {

        log.info("Buscando turno por ID: {}", id);
        return turnoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turno no encontrado por el ID " + id));

    }

    @Override
    public Turno agregarTurno(Turno turno) {

        log.info("Agregando nuevo turno: {}", turno);
        return turnoRepository.save(turno);

    }

    @Override
    public Turno actualizarTurno(Turno turno) {

        log.info("Actualizando turno con ID {}: {}", turno.getId(), turno);
        var turnoEncontrado = turnoRepository.findById(turno.getId()).orElseThrow(() -> new EntityNotFoundException("Turno no encontrado por el ID " + turno.getId()));
        turnoEncontrado.setNombreH(turno.getNombreH());
        turnoEncontrado.setDescripcion(turno.getDescripcion());
        return turnoRepository.save(turnoEncontrado);

    }

    @Override
    public void eliminarTurno(Long id) {

        log.info("Eliminando turno con ID: {}", id);
        var turnoEncontrado = turnoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turno no encontrado por el ID " + id));
        turnoRepository.delete(turnoEncontrado);

    }

}
