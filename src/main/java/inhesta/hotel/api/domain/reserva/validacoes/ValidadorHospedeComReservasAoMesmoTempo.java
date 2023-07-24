package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.reserva.ReservaRepository;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHospedeComReservasAoMesmoTempo implements ValidadorCheckInComParametro {

    @Autowired
    private ReservaRepository reservaRepository;

    public void validarCheckIn(DadosCheckIn dados){
        var reserva = reservaRepository.existsReservaByHospedeIdAndCheckOutIsNull(dados.idHospede());
        if (reserva){
            throw new ValidacaoException("Um hospede não pode fazer mais de uma reserva ao mesmo tempo");
        }
    }

}
