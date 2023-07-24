package inhesta.hotel.api.domain.reserva.checkOut;

import inhesta.hotel.api.domain.ValidacaoException;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import inhesta.hotel.api.domain.reserva.Reserva;
import inhesta.hotel.api.domain.reserva.ReservaRepository;
import inhesta.hotel.api.domain.reserva.validacoes.ValidadorCheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static inhesta.hotel.api.domain.quarto.StatusQuarto.DISPONIVEL;
import static inhesta.hotel.api.domain.quarto.StatusQuarto.OCUPADO;

@Service
public class CheckOut {

    @Autowired
    private ReservaRepository reservaRepository;


    public DadosDetalhamentoCheckOut checkOut(DadosCheckOut dados){
        if (!reservaRepository.existsById(dados.idReserva())){
            throw new ValidacaoException("Id da Reserva informado não existe!");
        }

        var reserva = reservaRepository.getReferenceById(dados.idReserva());

        var checkOut = LocalDateTime.now();
        var checkIn = reserva.getCheckIn();
        var dias = checkIn.until(checkOut, ChronoUnit.DAYS);

        var valorTotal = dias * reserva.getQuarto().getPrecoQuarto();

        reserva.setCheckOut(checkOut);
        reserva.setValorTotal(valorTotal);

        reserva.getQuarto().setStatusQuarto(DISPONIVEL);

        return new DadosDetalhamentoCheckOut(reserva);
    }

}
