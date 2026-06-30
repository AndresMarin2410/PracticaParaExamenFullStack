package cl.practicaExamen.MicroService_Orden.Controller;

import cl.practicaExamen.MicroService_Orden.Dto.OrdenResponse;
import cl.practicaExamen.MicroService_Orden.Model.Orden;
import cl.practicaExamen.MicroService_Orden.Service.OrdenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden")
@Slf4j
@Tag(name = "Ordenes", description = "Operaciones relacionadas con las ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    //listar ordenes
    @Operation(summary = "Listar Ordenes", description = "Lista todas la ordenes registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operacion realizada con exito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Orden> listarOrdenes() {
        log.info("GET /api/orden");
        return ordenService.listarOrdenes();
    }
    //buscar por id de la orden
    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Buscar una orden por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operacion realizada con exito"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interrno del servidor")
    })
    public OrdenResponse buscarOrdenPorId(@PathVariable Long id) {
        log.info("GET /api/orden/{id}");
        return ordenService.buscarOrdenPorId(id);
    }

    //buscar por usuario id
    @GetMapping("/producto/{id}")
    @Operation(summary = "Buscar orden por usuario ID", description = "Buscar una orden mediante el usuario id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Operacion realizada con exito"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public OrdenResponse buscarOrdenPorProductoId(@PathVariable Long id) {
        log.info("GET /api/orden/producto/{id}");
        return ordenService.buscarOrdenPorIdUsuario(id);
    }

    //crear orden

}
