package inhesta.hotel.api.controller;

import inhesta.hotel.api.domain.endereco.Endereco;
import inhesta.hotel.api.domain.hospede.DTO.DadosDetalhamentoHospede;
import inhesta.hotel.api.domain.quarto.DTO.DadosDetalhamentoQuarto;
import inhesta.hotel.api.domain.quarto.StatusQuarto;
import inhesta.hotel.api.domain.reserva.checkIn.CheckIn;
import inhesta.hotel.api.domain.reserva.checkIn.DTO.DadosCheckIn;
import inhesta.hotel.api.domain.reserva.checkIn.DTO.DadosDetalhamentoCheckIn;
import inhesta.hotel.api.domain.reserva.checkOut.CheckOut;
import inhesta.hotel.api.domain.reserva.checkOut.DTO.DadosCheckOut;
import inhesta.hotel.api.domain.reserva.checkOut.DTO.DadosDetalhamentoCheckOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ReservaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCheckIn> dadosCheckIn;

    @Autowired
    private JacksonTester<DadosDetalhamentoCheckIn> dadosDetalhamentoCheckIn;

    @MockBean
    private CheckIn checkIn;

    @Autowired
    private JacksonTester<DadosCheckOut> dadosCheckOut;

    @Autowired
    private JacksonTester<DadosDetalhamentoCheckOut> dadosDetalhamentoCheckOut;

    @MockBean
    private CheckOut checkOut;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void checkIn_cenario1() throws Exception {
        var response = mvc.perform(post("/reserva/checkIn"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando as informacoes estao validas")
    @WithMockUser
    void checkIn_cenario2() throws Exception {;

        var endereco = new Endereco("rua 1", "bairro", "12345678", "Brasilia", "DF", "complemento", "1");
        var dadosDetalhamnetoHospede = new DadosDetalhamentoHospede(2L, "vinicius", "14997947840", "rodrigo.ferreira1@voll.med", endereco);
        var dadosDetalhamentoQuarto = new DadosDetalhamentoQuarto("210", "Solterio", StatusQuarto.OCUPADO, 210.0);
        var dadosDetalhamentoReserva = new DadosDetalhamentoCheckIn(null, dadosDetalhamnetoHospede, dadosDetalhamentoQuarto, LocalDateTime.now());
        when(checkIn.checkIn(any())).thenReturn(dadosDetalhamentoReserva);

        var response = mvc.perform(
                        post("/reserva/checkIn")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosCheckIn.write(
                                                new DadosCheckIn(2l, 5l)
                                        ).getJson()
                                )
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoCheckIn.write(dadosDetalhamentoReserva).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void checkOut_cenario1() throws Exception {
        var response = mvc.perform(post("/reserva/checkIn"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando as informacoes estao validas")
    @WithMockUser
    void checkOut_cenario2() throws Exception {;

        var endereco = new Endereco("rua 1", "bairro", "12345678", "Brasilia", "DF", "complemento", "1");
        var dadosDetalhamnetoHospede = new DadosDetalhamentoHospede(2L, "vinicius", "14997947840", "rodrigo.ferreira1@voll.med", endereco);
        var dadosDetalhamentoQuarto = new DadosDetalhamentoQuarto("210", "Solterio", StatusQuarto.OCUPADO, 210.0);
        var dadosDetalhamentoReserva = new DadosDetalhamentoCheckOut(1l, dadosDetalhamnetoHospede, dadosDetalhamentoQuarto, LocalDateTime.now(), LocalDateTime.now(), 0.0);
        when(checkOut.checkOut(any())).thenReturn(dadosDetalhamentoReserva);

        var response = mvc.perform(
                        post("/reserva/checkOut")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosCheckOut.write(
                                                new DadosCheckOut(1l)
                                        ).getJson()
                                )
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoCheckOut.write(dadosDetalhamentoReserva).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}