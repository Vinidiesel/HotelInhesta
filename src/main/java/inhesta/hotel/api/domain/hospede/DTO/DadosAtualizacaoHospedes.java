package inhesta.hotel.api.domain.hospede.DTO;

import inhesta.hotel.api.domain.endereco.DTO.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoHospedes(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco
) {

}
