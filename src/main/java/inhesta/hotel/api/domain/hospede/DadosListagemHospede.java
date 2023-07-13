package inhesta.hotel.api.domain.hospede;

public record DadosListagemHospede(
        String nome,
        String telefone,
        String email
) {
    public DadosListagemHospede(Hospede hospede){
        this(hospede.getNome(), hospede.getTelefone(), hospede.getEmail());
    }
}
