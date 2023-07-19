package inhesta.hotel.api.domain.usuario;

public record DadosDetalhamentoUsuario(
        String login,
        String role
) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getLogin(), usuario.getRole());
    }
}
