package inhesta.hotel.api.domain.reserva.checkIn;

import jakarta.validation.constraints.NotNull;


public record DadosCheckIn(
        @NotNull
        Long idHospede,
        @NotNull
        Long idQuarto
) {
}
