package cl.practicaExamen.MicroService_Orden.Service;

import cl.practicaExamen.MicroService_Orden.Dto.OrdenRequest;
import cl.practicaExamen.MicroService_Orden.Dto.OrdenResponse;
import cl.practicaExamen.MicroService_Orden.Mapper.OrdenMapper;
import cl.practicaExamen.MicroService_Orden.Model.Orden;
import cl.practicaExamen.MicroService_Orden.Repository.OrdenRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
@Slf4j
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private OrdenMapper ordenMapper;

    //Listar ordenes
    public List<Orden> listarOrdenes() {
        log.info("Listando todas las ordenes registradas");
        return ordenRepository.findAll();
    }

    //buscarPorId
    public OrdenResponse buscarOrdenPorId(Long id) {
        log.info("Buscando orden con el ID: {}", id);
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Orden no encontrada"));
        return ordenMapper.toResponse(orden);
    }

    //buscar por id usuario
    public OrdenResponse buscarOrdenPorIdUsuario(Long idUsuario) {
        log.info("Buscando ordenes con el ID usuario: {}",idUsuario);
        Orden orden = ordenRepository.findByIdUsuario(idUsuario)
                .orElseThrow(() -> new NoSuchElementException("Orden no encontrada"));
        return ordenMapper.toResponse(orden);
    }
    //crear
    public OrdenResponse crearOrden(OrdenRequest request) {
        log.info("Creando un nuevo usuario");
        Orden orden = Orden.builder()
                .idProducto(request.getIdProducto())
                .cantidad(request.getCantidad())
                .estado(request.getEstado())
                .precioTotal(request.getPrecioTotal())
                .fechaOrden(request.getFechaOrden())
                .build();
        Orden creado = ordenRepository.save(orden);
        return ordenMapper.toResponse(creado);
    }
    //actualizar
    public OrdenResponse actualizarOrden(Long id, OrdenRequest request) {
        log.info("Actualizando orden con el ID: {}", id);
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Orden no encontrada"));

        if(request.getCantidad() != null) {
            orden.setCantidad(request.getCantidad());
        }
        if(request.getEstado() != null) {
            orden.setEstado(request.getEstado());
        }
        if(request.getPrecioTotal() != null) {
            orden.setPrecioTotal(request.getPrecioTotal());
        }
        if(request.getFechaOrden() != null) {
            orden.setFechaOrden(request.getFechaOrden());
        }
        orden = ordenRepository.save(orden);
        return ordenMapper.toResponse(orden);
    }

    //Eliminar
    public void eliminarOrden(Long id) {
        log.info("Eliminando orden con el ID: {}", id);
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Orden no encontrada"));
        ordenRepository.delete(orden);
    }
}
