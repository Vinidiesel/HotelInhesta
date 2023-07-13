package inhesta.hotel.api.domain.quarto;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "quartos")
@Entity(name = "Quarto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroQuarto;
    private String tipoQuarto;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private StatusQuarto statusQuarto;
    private Double precoQuarto;

    public Quarto(DadosCadastroQuartos dados) {
        this.ativo = true;
        this.numeroQuarto = dados.numeroQuarto();
        this.tipoQuarto = dados.tipoQuarto();
        this.statusQuarto = dados.statusQuarto();
        this.precoQuarto = dados.precoQuarto();
    }

    public void atualizarInformacoes(DadosAtualizacaoQuartos dados) {
        if (dados.numeroQuarto() != null){
            this.numeroQuarto = dados.numeroQuarto();
        }
        if (dados.tipoQuarto() != null){
            this.tipoQuarto = dados.tipoQuarto();
        }
        if (dados.statusQuarto() != null){
            this.statusQuarto = dados.statusQuarto();
        }
        if (dados.precoQuarto() != null){
            this.precoQuarto = dados.precoQuarto();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
