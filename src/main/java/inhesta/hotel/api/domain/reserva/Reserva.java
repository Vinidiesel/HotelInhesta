package inhesta.hotel.api.domain.reserva;

import inhesta.hotel.api.domain.hospede.Hospede;
import inhesta.hotel.api.domain.quarto.Quarto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "reservas")
@Entity(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double valorTotal;

}
