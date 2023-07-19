package inhesta.hotel.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuarios(

        @NotBlank(message = "O email é obrigatorio")
        @Email(message = "Formato do email é inválido")
        String login,
        @NotBlank(message = "A senha é obrigatoria")
        String senha
) {
}
