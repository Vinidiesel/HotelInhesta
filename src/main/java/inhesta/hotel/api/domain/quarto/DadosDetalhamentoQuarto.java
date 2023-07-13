package inhesta.hotel.api.domain.quarto;

public record DadosDetalhamentoQuarto(
        String numeroQuarto,
        String tipoQuarto,
        StatusQuarto statusQuarto,
        Double precoQuarto
) {
    public DadosDetalhamentoQuarto(Quarto quarto) {
        this(quarto.getNumeroQuarto(), quarto.getTipoQuarto(), quarto.getStatusQuarto(), quarto.getPrecoQuarto());
    }
}
