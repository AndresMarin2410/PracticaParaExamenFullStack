package cl.practicaExamen.MicroService_Producto.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@NotNull
@AllArgsConstructor
public class ProductoResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private LocalDate fechaVencimiento;
}
