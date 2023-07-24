package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.reserva.checkIn.CheckIn;
import inhesta.hotel.api.domain.reserva.checkIn.DadosDetalhamentoCheckIn;
import inhesta.hotel.api.domain.reserva.checkIn.DadosCheckIn;
import inhesta.hotel.api.domain.reserva.checkOut.CheckOut;
import inhesta.hotel.api.domain.reserva.checkOut.DadosCheckOut;
import inhesta.hotel.api.domain.reserva.checkOut.DadosDetalhamentoCheckOut;
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
    private CheckIn checkIn;

    @Autowired
    private CheckOut checkOut;

    @PostMapping("/checkIn")
    @Transactional
    public ResponseEntity ckeckIn(@RequestBody @Valid DadosCheckIn dados){
        var dto = checkIn.checkIn(dados);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/checkOut")
    @Transactional
    public ResponseEntity ckeckOut(@RequestBody @Valid DadosCheckOut dados){
        var dto = checkOut.checkOut(dados);
        return ResponseEntity.ok(dto);
    }
}
