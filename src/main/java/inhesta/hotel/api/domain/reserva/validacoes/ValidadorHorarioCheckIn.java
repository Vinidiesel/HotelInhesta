package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorHorarioCheckIn implements ValidadorCheckInSemParametro {

    public void validarCheckIn(){
        var dataCheckIn = LocalDateTime.now();

        var antesDaAberturaDoCheckIn = dataCheckIn.getHour() < 12;
        var depoisDaAberturaDoCheckIn = dataCheckIn.getHour() > 20;
        if (antesDaAberturaDoCheckIn || depoisDaAberturaDoCheckIn){
            throw new ValidacaoException("Check-In fora do horario!");
        }
    }

}
