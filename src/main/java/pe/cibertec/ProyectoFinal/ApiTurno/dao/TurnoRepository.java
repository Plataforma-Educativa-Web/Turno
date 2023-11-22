package pe.cibertec.ProyectoFinal.ApiTurno.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.ApiTurno.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
    Optional<Turno> findByNombre (String nombre);
    
}
