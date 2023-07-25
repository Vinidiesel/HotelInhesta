package inhesta.hotel.api.domain.quarto.repository;

import inhesta.hotel.api.domain.quarto.Quarto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Page<Quarto> findAllByAtivoTrue(Pageable pageable);

    @Query("""
select q.ativo
from Quarto  q
where q.id = :id
""")
    Boolean findAtivoById(Long id);
}
