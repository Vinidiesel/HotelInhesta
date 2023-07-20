package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.reserva.AgendaDeReservas;
import inhesta.hotel.api.domain.reserva.DadosDetalhamentoReserva;
import inhesta.hotel.api.domain.reserva.DadosAgendamentoReserva;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private AgendaDeReservas agendaDeReservas;

    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DadosAgendamentoReserva dados){
        agendaDeReservas.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoReserva(null, null,null,null,null,null));
    }
}
