package inhesta.hotel.api.domain.reserva.validacoes;

import inhesta.hotel.api.domain.reserva.checkIn.DTO.DadosCheckIn;

public interface ValidadorCheckInComParametro {

    void validarCheckIn(DadosCheckIn dados);

}
