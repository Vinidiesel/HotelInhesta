package inhesta.hotel.api.domain.reserva.repository;

import inhesta.hotel.api.domain.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Boolean existsReservaByHospedeIdAndCheckOutIsNull(Long id);
}
