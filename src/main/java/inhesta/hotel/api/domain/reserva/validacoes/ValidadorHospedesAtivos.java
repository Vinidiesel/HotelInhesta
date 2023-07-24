package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.hospede.HospedeRepository;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHospedesAtivos implements ValidadorCheckInComParametro {

    @Autowired
    private HospedeRepository hospedeRepository;

    public void validarCheckIn(DadosCheckIn dados){
        var hospedeEstaAtivo = hospedeRepository.findAtivoById(dados.idHospede());
        if (!hospedeEstaAtivo){
            throw new ValidacaoException("Reserva não pode ser feita com um Hospede inativo");
        }
    }

}
