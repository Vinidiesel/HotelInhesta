package inhesta.hotel.api.domain.reserva.checkIn;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.hospede.HospedeRepository;
import inhesta.hotel.api.domain.quarto.QuartoRepository;
import inhesta.hotel.api.domain.reserva.Reserva;
import inhesta.hotel.api.domain.reserva.ReservaRepository;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import inhesta.hotel.api.domain.reserva.validacoes.ValidadorCheckInComParametro;
import inhesta.hotel.api.domain.reserva.validacoes.ValidadorCheckInSemParametro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static inhesta.hotel.api.domain.quarto.StatusQuarto.OCUPADO;

@Service
public class CheckIn {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private List<ValidadorCheckInComParametro> validadoresComParametros;

    @Autowired
    private List<ValidadorCheckInSemParametro> validadoresSemParametros;

    public DadosDetalhamentoCheckIn checkIn(DadosCheckIn dados){
        if (!hospedeRepository.existsById(dados.idHospede())){
            throw new ValidacaoException("Id do hospede informado não existe!");
        }
        if (!quartoRepository.existsById(dados.idQuarto())){
            throw new ValidacaoException("Id do quarto informado não existe!");
        }

        validadoresComParametros.forEach(v -> v.validarCheckIn(dados));
        validadoresSemParametros.forEach(ValidadorCheckInSemParametro::validarCheckIn);

        var hospede = hospedeRepository.getReferenceById(dados.idHospede());
        var quarto = quartoRepository.getReferenceById(dados.idQuarto());

        var reserva = new Reserva(null, hospede, quarto, LocalDateTime.now(), null, null);
        quarto.setStatusQuarto(OCUPADO);

        reservaRepository.save(reserva);

        return new DadosDetalhamentoCheckIn(reserva);
    }

}
