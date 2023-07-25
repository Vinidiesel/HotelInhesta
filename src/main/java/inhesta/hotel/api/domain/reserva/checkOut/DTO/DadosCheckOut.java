package inhesta.hotel.api.domain.reserva.checkOut.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCheckOut(
        @NotNull
        Long idReserva
) {
}
