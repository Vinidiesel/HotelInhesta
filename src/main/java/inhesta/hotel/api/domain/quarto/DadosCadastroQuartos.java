package inhesta.hotel.api.domain.quarto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroQuartos(

        @NotBlank(message = "O numero do quarto é obrigatorio")
        String numeroQuarto,
        @NotBlank(message = "O tipo do quarto é obrigatorio")
        String tipoQuarto,
        @NotNull(message = "O status do quarto é obrigatorio")
        StatusQuarto statusQuarto,
        @NotNull(message = "O preço do quarto é obrigatorio")
        Double precoQuarto
) {
}
