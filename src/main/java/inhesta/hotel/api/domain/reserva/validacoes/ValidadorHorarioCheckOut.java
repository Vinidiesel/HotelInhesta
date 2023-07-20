package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.reserva.DadosAgendamentoReserva;

import java.time.LocalDateTime;

public class ValidadorHorarioCheckOut {

    public void validar(DadosAgendamentoReserva dados){
        var dataCheckOut = dados.checkOut();

        var antesDaAberturaDoCheckOut = dataCheckOut.getHour() < 11;
        var depoisDoFechamentoDoCheckOut = dataCheckOut.getHour() > 12;
        if (antesDaAberturaDoCheckOut || depoisDoFechamentoDoCheckOut){
            throw new ValidacaoException("Check-Out fora do horario!");
        }
    }

}
