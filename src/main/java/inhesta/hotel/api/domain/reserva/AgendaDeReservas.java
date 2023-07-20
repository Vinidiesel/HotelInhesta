package inhesta.hotel.api.domain.reserva;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.hospede.HospedeRepository;
import inhesta.hotel.api.domain.quarto.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AgendaDeReservas {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public void agendar(DadosAgendamentoReserva dados){
        if (!hospedeRepository.existsById(dados.idHospede())){
            throw new ValidacaoException("Id do hospede informado não existe!");
        }
        if (!quartoRepository.existsById(dados.idQuarto())){
            throw new ValidacaoException("Id do quarto informado não existe!");
        }

        var hospede = hospedeRepository.findById(dados.idHospede()).get();
        var quarto = quartoRepository.findById(dados.idQuarto()).get();

        var checkOut = dados.checkOut();
        var checkIn = LocalDateTime.now();
        var dias = checkIn.until(checkOut, ChronoUnit.DAYS);

        var valorTotal = dias * quarto.getPrecoQuarto();

        var reserva = new Reserva(null, hospede, quarto, checkIn, checkOut, valorTotal);

        reservaRepository.save(reserva);
    }

}
