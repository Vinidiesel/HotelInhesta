package inhesta.hotel.api.domain.quarto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Page<Quarto> findAllByAtivoTrue(Pageable pageable);
}
