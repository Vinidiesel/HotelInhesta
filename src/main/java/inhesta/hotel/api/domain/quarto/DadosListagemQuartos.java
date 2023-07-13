package inhesta.hotel.api.domain.quarto;

public record DadosListagemQuartos(
        String numeroQuarto,
        String tipoQuarto,
        StatusQuarto statusQuarto,
        Double precoQuarto
) {
    public DadosListagemQuartos(Quarto quarto){
        this(quarto.getNumeroQuarto(), quarto.getTipoQuarto(), quarto.getStatusQuarto(), quarto.getPrecoQuarto());
    }
}
