package inhesta.hotel.api.domain.usuario.DTO;

import inhesta.hotel.api.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(
        String login,
        String role
) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getLogin(), usuario.getRole());
    }
}
