package inhesta.hotel.api.domain.hospede;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    Page<Hospede> findAllByAtivoTrue(Pageable pageable);
}
