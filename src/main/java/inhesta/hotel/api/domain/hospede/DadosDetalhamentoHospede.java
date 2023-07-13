package inhesta.hotel.api.domain.hospede;

import inhesta.hotel.api.domain.endereco.Endereco;

public record DadosDetalhamentoHospede(
        Long id,
        String nome,
        String telefone,
        String email,
        Endereco endereco
) {

    public DadosDetalhamentoHospede(Hospede hospede) {
        this(hospede.getId(), hospede.getNome(), hospede.getTelefone(), hospede.getEmail(), hospede.getEndereco());
    }
}
