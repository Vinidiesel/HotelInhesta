package inhesta.hotel.api.domain.reserva.checkOut;

import inhesta.hotel.api.domain.hospede.DadosDetalhamentoHospede;
import inhesta.hotel.api.domain.quarto.DadosDetalhamentoQuarto;
import inhesta.hotel.api.domain.reserva.Reserva;

import java.time.LocalDateTime;

public record DadosDetalhamentoCheckOut(
        Long id,
        DadosDetalhamentoHospede hospede,
        DadosDetalhamentoQuarto quarto,
        LocalDateTime checkIn,
        LocalDateTime checkOut,
        Double valorTotal
) {
    public DadosDetalhamentoCheckOut(Reserva dados) {
        this(dados.getId(), new DadosDetalhamentoHospede(dados.getHospede()), new DadosDetalhamentoQuarto(dados.getQuarto()), dados.getCheckIn(), dados.getCheckOut(), dados.getValorTotal());
    }
}
