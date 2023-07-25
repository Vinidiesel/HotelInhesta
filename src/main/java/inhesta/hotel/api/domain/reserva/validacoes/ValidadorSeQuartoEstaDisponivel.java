package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.quarto.repository.QuartoRepository;
import inhesta.hotel.api.domain.reserva.checkIn.DTO.DadosCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static inhesta.hotel.api.domain.quarto.StatusQuarto.DISPONIVEL;

@Component
public class ValidadorSeQuartoEstaDisponivel implements ValidadorCheckInComParametro {

    @Autowired
    private QuartoRepository quartoRepository;

    public void validarCheckIn(DadosCheckIn dados){
        var quarto = quartoRepository.getReferenceById(dados.idQuarto());
        if (quarto.getStatusQuarto() != DISPONIVEL){
            throw new ValidacaoException("O quarto não está disponivel para reserva");
        }
    }

}
