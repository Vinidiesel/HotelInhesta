package inhesta.hotel.api.domain.hospede;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    Page<Hospede> findAllByAtivoTrue(Pageable pageable);

    @Query("""
select h.ativo
from Hospede  h
where h.id = :id
""")
    Boolean findAtivoById(Long id);
}
