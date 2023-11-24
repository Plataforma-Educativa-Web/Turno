package pe.cibertec.ProyectoFinal.ApiTurno.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiTurno.dao.TurnoRepository;
import pe.cibertec.ProyectoFinal.ApiTurno.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiTurno.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiTurno.service.TurnoService;

@Service

public class TurnoServiceImpl implements TurnoService {
    
    @Autowired
    
    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> findAll() {
        
        return (List<Turno>) turnoRepository.findAll();
        
    }

    @Override
    public Turno findByNombreH(String nombreH) {
        
        return turnoRepository.findByNombreH(nombreH).orElseThrow(() -> new EntityNotFoundException("Turno no encontrada con el nombre"+nombreH.toString()));
        
    }

    @Override
    public Turno buscarPorId(Long id) {
        
        return turnoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Turno no encontrado por el id"+id.toString()));
    }

    @Override
    public Turno agregarTurno(Turno turno) {
        
        return turnoRepository.save(turno);
        
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        
        var TurnoF = turnoRepository.findById(turno.getId()).get();
        TurnoF.setNombreH(turno.getNombreH());
        TurnoF.setDescripcion(turno.getDescripcion());
        
        return turnoRepository.save(TurnoF);
         
    }

    @Override
    public void eliminarTurno(Long id) {
        
        var TurnoF = turnoRepository.findById(id).get();
        
        turnoRepository.delete(TurnoF);
        
        
    }
    
}
