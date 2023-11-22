package pe.cibertec.ProyectoFinal.ApiTurno.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiTurno.entity.Turno;

public interface TurnoService {

    public List<Turno> findAll();

    public Turno findByNombre(String nombre);

    public Turno buscarPorId(Long id);

    public Turno agregarTurno(Turno turno);

    public Turno actualizarTurno(Turno turno);

    public void eliminarTurno(Long id);

}
