package inhesta.hotel.api.domain.reserva;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoReserva(
        @NotNull
        Long idHospede,
        @NotNull
        Long idQuarto,
        @NotNull
        @Future
        LocalDateTime checkOut
) {
}
