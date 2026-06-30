package cl.practicaExamen.MicroService_Orden.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenRequest {

    @NotNull(message = "El id del producto debe ser obligatorio")
    private Long idProducto;

    @NotNull(message = "La cantidad es obligatorio")
    @PositiveOrZero(message = "La cantidad debe ser mayor a 0")
    private int cantidad;

    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 50, message = "El estado tiene un limite de 50 caracteres")
    private String estado;

    @NotNull(message = "El precio total es obligatorio")
    @PositiveOrZero(message = "El precio total debe ser mayor a 0")
    private double precioTotal;

    @FutureOrPresent(message = "La fecha no puede ser pasada")
    @NotNull(message = "La fecha de la creacion de la orden es obligatoria")
    private LocalDate fechaOrden;
}
