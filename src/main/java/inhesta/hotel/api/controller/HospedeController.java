package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.hospede.*;
import inhesta.hotel.api.domain.hospede.DTO.DadosAtualizacaoHospedes;
import inhesta.hotel.api.domain.hospede.DTO.DadosCadastroHospede;
import inhesta.hotel.api.domain.hospede.DTO.DadosDetalhamentoHospede;
import inhesta.hotel.api.domain.hospede.DTO.DadosListagemHospede;
import inhesta.hotel.api.domain.hospede.repository.HospedeRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/hospedes")
@SecurityRequirement(name = "bearer-key")
public class HospedeController {

    @Autowired
    private HospedeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastra(@RequestBody @Valid DadosCadastroHospede dados, UriComponentsBuilder uriComponentsBuilder){
        var hospede = new Hospede(dados);
        repository.save(hospede);

        var uri = uriComponentsBuilder.path("/hospedes/{id}").buildAndExpand(hospede.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoHospede(hospede));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemHospede>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemHospede::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoHospedes dados){
        var hospede = repository.getReferenceById(dados.id());
        hospede.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoHospede(hospede));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var hospede = repository.getReferenceById(id);
        hospede.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var hospede = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoHospede(hospede));
    }

}
