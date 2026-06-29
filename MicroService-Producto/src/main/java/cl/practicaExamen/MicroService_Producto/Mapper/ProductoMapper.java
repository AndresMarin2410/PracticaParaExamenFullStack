package cl.practicaExamen.MicroService_Producto.Mapper;

import cl.practicaExamen.MicroService_Producto.Dto.ProductoRequest;
import cl.practicaExamen.MicroService_Producto.Dto.ProductoResponse;
import cl.practicaExamen.MicroService_Producto.Model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto fromRequest(ProductoRequest request) {
        return Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .stock(request.getStock())
                .fechaVencimiento(request.getFechaVencimiento())
                .build();
    }

    public ProductoResponse toResponse(Producto producto) {
        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .fechaVencimiento(producto.getFechaVencimiento())
                .build();
    }

}
