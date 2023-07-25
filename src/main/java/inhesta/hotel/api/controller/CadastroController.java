package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.usuario.DTO.DadosCadastroUsuarios;
import inhesta.hotel.api.domain.usuario.DTO.DadosDetalhamentoUsuario;
import inhesta.hotel.api.domain.usuario.Usuario;
import inhesta.hotel.api.domain.usuario.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
@SecurityRequirement(name = "bearer-key")
public class CadastroController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastra(@RequestBody @Valid DadosCadastroUsuarios dados, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriComponentsBuilder.path("/hospedes/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }



}
