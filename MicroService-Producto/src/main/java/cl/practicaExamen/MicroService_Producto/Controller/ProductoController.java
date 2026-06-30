package cl.practicaExamen.MicroService_Producto.Controller;

import cl.practicaExamen.MicroService_Producto.Dto.ProductoRequest;
import cl.practicaExamen.MicroService_Producto.Dto.ProductoResponse;
import cl.practicaExamen.MicroService_Producto.Model.Producto;
import cl.practicaExamen.MicroService_Producto.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
@Slf4j
@RestController
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    @Operation(summary = "Listar productos", description = "Lista todos los productos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<Producto> listarProductos() {
        log.info("GET /api/producto");
        return productoService.listarProducto();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar producto por ID", description = "Busca un producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ProductoResponse buscarProductoPorId(@PathVariable Long id) {
        log.info("GET /api/producto/{}", id);
        return productoService.buscarPorId(id);
    }

    @PostMapping()
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion relacionada con exito",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = ProductoResponse.class))),

            @ApiResponse(responseCode = "400", description = "Datos invalidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ProductoResponse> crearProducto(@Valid @RequestBody ProductoRequest request) {
        log.info("POST /api/producto");
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza la informacion de un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = ProductoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Datos invalidos"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<ProductoResponse> actualizarProducto(@Valid Long id, @RequestBody ProductoRequest request) {
        log.info("PUT /api/producto/{id}");
        return ResponseEntity.ok(productoService.actualizarProducto(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto registrado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado con exito"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        log.info("DELETE /api/producto/{id}");
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
