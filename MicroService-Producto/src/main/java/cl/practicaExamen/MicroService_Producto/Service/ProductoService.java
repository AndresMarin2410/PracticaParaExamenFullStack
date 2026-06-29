package cl.practicaExamen.MicroService_Producto.Service;

import cl.practicaExamen.MicroService_Producto.Dto.ProductoRequest;
import cl.practicaExamen.MicroService_Producto.Dto.ProductoResponse;
import cl.practicaExamen.MicroService_Producto.Mapper.ProductoMapper;
import cl.practicaExamen.MicroService_Producto.Model.Producto;
import cl.practicaExamen.MicroService_Producto.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@Slf4j
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;


    public List<Producto> listarProducto() {
        log.info("Listando todos los productos registrados");
        return productoRepository.findAll();
    }

    public ProductoResponse buscarPorId(Long id) {
        log.info("Buscando producto con el ID: {}", id);
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
        return productoMapper.toResponse(producto);
    }

    public ProductoResponse crearProducto(ProductoRequest request) {
        log.info("Creando usuario...");
        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .stock(request.getStock())
                .fechaVencimiento(request.getFechaVencimiento())
                .build();
        Producto creado = productoRepository.save(producto);
        return productoMapper.toResponse(creado);
    }

    public ProductoResponse actualizarProducto(Long id, ProductoRequest request) {
        log.info("Actualizando producto con el ID: {}", id);
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Producto no encontrado"));
        if(request.getNombre() != null) {
            producto.setNombre(request.getNombre());
        }
        if(request.getDescripcion() != null) {
            producto.setDescripcion(request.getDescripcion());
        }
        if(request.getPrecio() != null) {
            producto.setStock(request.getStock());
        }
        if(request.getFechaVencimiento() != null) {
            producto.setFechaVencimiento(request.getFechaVencimiento());
        }
        producto = productoRepository.save(producto);
        return productoMapper.toResponse(producto);
    }

    public void eliminarProducto(Long id) {
        log.info("Eliminando producto con el ID: {}", id);
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
        productoRepository.delete(producto);
    }
}
