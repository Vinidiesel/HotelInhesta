package inhesta.hotel.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O logradouro é obrigatorio")
        String logradouro,
        @NotBlank(message = "O bairro é obrigatorio")
        String bairro,
        @NotBlank(message = "O CEP é obrigatorio")
        @Pattern(regexp = "\\d{8}", message = "Formato do CEP é invalido")
        String cep,
        @NotBlank(message = "A cidade é obrigatorio")
        String cidade,
        @NotBlank(message = "A UF é obrigatorio")
        String uf,
        String complemento,
        @NotBlank(message = "O numero é obrigatorio")
        String numero
) {
}
