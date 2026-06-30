package cl.practicaExamen.MicroService_Orden.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordenes")
@Builder
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idProducto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private double precioTotal;

    @Column(nullable = false, name = "fecha_orden")
    private LocalDate fechaOrden;
}
