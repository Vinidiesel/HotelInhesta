package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.quarto.*;
import inhesta.hotel.api.domain.quarto.DTO.DadosAtualizacaoQuartos;
import inhesta.hotel.api.domain.quarto.DTO.DadosCadastroQuartos;
import inhesta.hotel.api.domain.quarto.DTO.DadosDetalhamentoQuarto;
import inhesta.hotel.api.domain.quarto.DTO.DadosListagemQuartos;
import inhesta.hotel.api.domain.quarto.repository.QuartoRepository;
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
@RequestMapping("/quartos")
@SecurityRequirement(name = "bearer-key")
public class QuartoController {

    @Autowired
    private QuartoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroQuartos dados, UriComponentsBuilder uriComponentsBuilder){
        var quarto = new Quarto(dados);
        repository.save(quarto);

        var uri = uriComponentsBuilder.path("/quartos/{id}").buildAndExpand(quarto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoQuarto(quarto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemQuartos>> listar(@PageableDefault(size = 10, sort = {"numeroQuarto"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemQuartos::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoQuartos dados){
        var quarto = repository.getReferenceById(dados.id());
        quarto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoQuarto(quarto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var quarto = repository.getReferenceById(id);
        quarto.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var quarto = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoQuarto(quarto));
    }
}
