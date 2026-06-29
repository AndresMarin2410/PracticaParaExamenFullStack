package cl.practicaExamen.MicroService_Producto.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "El precio debe ser obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock no debe ser negativo")
    private int stock;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha de vencimiento no puede ser pasada")
    private LocalDate fechaVencimiento;
}
