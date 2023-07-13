package inhesta.hotel.api.domain.hospede;

import inhesta.hotel.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroHospede(

        @NotBlank(message = "O nome é obrigatorio")
        String nome,
        @NotBlank(message = "O telefone é obrigatorio")
        String telefone,
        @NotBlank(message = "O email é obrigatorio")
        @Email(message = "Formato de email inválido")
        String email,
        @NotNull(message = "O endereço é obrigatorio")
        @Valid
        DadosEndereco endereco
        ) {
}
