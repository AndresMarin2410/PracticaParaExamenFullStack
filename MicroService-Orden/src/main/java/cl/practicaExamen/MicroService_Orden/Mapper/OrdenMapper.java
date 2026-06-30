package cl.practicaExamen.MicroService_Orden.Mapper;

import cl.practicaExamen.MicroService_Orden.Dto.OrdenRequest;
import cl.practicaExamen.MicroService_Orden.Dto.OrdenResponse;
import cl.practicaExamen.MicroService_Orden.Model.Orden;
import org.springframework.stereotype.Component;

@Component
public class OrdenMapper {

    public Orden fromRequest(OrdenRequest request) {
        return Orden.builder()
                .idProducto(request.getIdProducto())
                .cantidad(request.getCantidad())
                .estado(request.getEstado())
                .precioTotal(request.getPrecioTotal())
                .fechaOrden(request.getFechaOrden())
                .build();
    }

    public OrdenResponse toResponse(Orden orden) {
        return OrdenResponse.builder()
                .id(orden.getId())
                .idProducto(orden.getIdProducto())
                .cantidad(orden.getCantidad())
                .estado(orden.getEstado())
                .precioTotal(orden.getPrecioTotal())
                .fechaOrden(orden.getFechaOrden())
                .build();
    }
}
