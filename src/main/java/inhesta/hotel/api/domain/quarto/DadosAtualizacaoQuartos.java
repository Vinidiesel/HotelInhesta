package inhesta.hotel.api.domain.quarto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoQuartos(
        @NotNull
        Long id,
        String numeroQuarto,
        String tipoQuarto,
        StatusQuarto statusQuarto,
        Double precoQuarto
) {
}
