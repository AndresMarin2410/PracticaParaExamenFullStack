package cl.practicaExamen.MicroService_Orden.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenResponse {
    private Long id;
    private Long idProducto;
    private Integer cantidad;
    private String estado;
    private Double precioTotal;
    private LocalDate fechaOrden;
}
