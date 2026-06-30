package cl.practicaExamen.MicroService_Orden.Repository;

import cl.practicaExamen.MicroService_Orden.Model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrdenRepository extends JpaRepository<Orden, Long> {

    Optional<Orden> findByIdUsuario(Long idUsuario);
}
