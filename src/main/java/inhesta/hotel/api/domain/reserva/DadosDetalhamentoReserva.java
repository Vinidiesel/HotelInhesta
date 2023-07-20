package inhesta.hotel.api.domain.reserva;

import java.time.LocalDateTime;

public record DadosDetalhamentoReserva(
        Long id,
        Long idHospede,
        Long idQuarto,
        LocalDateTime checkIn,
        LocalDateTime checkOut,
        Double valorTotal
) {
}
