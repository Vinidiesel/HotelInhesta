package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.reserva.DadosAgendamentoReserva;

import java.time.LocalDateTime;

public class ValidadorHorarioCheckIn {

    public void validar(){
        var dataCheckIn = LocalDateTime.now();

        var antesDaAberturaDoCheckIn = dataCheckIn.getHour() < 12;
        var depoisDaAberturaDoCheckIn = dataCheckIn.getHour() > 20;
        if (antesDaAberturaDoCheckIn || depoisDaAberturaDoCheckIn){
            throw new ValidacaoException("Check-In fora do horario!");
        }
    }

}
