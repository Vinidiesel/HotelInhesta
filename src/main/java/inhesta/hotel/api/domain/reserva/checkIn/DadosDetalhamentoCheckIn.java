package inhesta.hotel.api.domain.reserva.checkIn;

import inhesta.hotel.api.domain.hospede.DadosDetalhamentoHospede;
import inhesta.hotel.api.domain.quarto.DadosDetalhamentoQuarto;
import inhesta.hotel.api.domain.reserva.Reserva;

import java.time.LocalDateTime;

public record DadosDetalhamentoCheckIn(
        Long id,
        DadosDetalhamentoHospede hospede,
        DadosDetalhamentoQuarto quarto,
        LocalDateTime checkIn
) {
    public DadosDetalhamentoCheckIn(Reserva dados) {
        this(dados.getId(), new DadosDetalhamentoHospede(dados.getHospede()), new DadosDetalhamentoQuarto(dados.getQuarto()), dados.getCheckIn());
    }
}
