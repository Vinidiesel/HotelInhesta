package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.hospede.DadosCadastroHospede;
import inhesta.hotel.api.domain.hospede.DadosDetalhamentoHospede;
import inhesta.hotel.api.domain.hospede.Hospede;
import inhesta.hotel.api.domain.usuario.DadosCadastroUsuarios;
import inhesta.hotel.api.domain.usuario.DadosDetalhamentoUsuario;
import inhesta.hotel.api.domain.usuario.Usuario;
import inhesta.hotel.api.domain.usuario.UsuarioRepository;
import inhesta.hotel.api.infra.security.SecurityConfigurations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastra(@RequestBody @Valid DadosCadastroUsuarios dados, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(dados);
        usuario.setSenha(passwordEncoder().encode(usuario.getPassword()));
        repository.save(usuario);

        var uri = uriComponentsBuilder.path("/hospedes/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
