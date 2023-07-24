package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.quarto.QuartoRepository;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorQuartosAtivos implements ValidadorCheckInComParametro {

    @Autowired
    private QuartoRepository quartoRepository;

    public void validarCheckIn(DadosCheckIn dados){
        var quartoEstaAtivo = quartoRepository.findAtivoById(dados.idQuarto());
        if (!quartoEstaAtivo){
            throw new ValidacaoException("Reserva não pode ser feita com um Quarto inativo");
        }
    }

}
