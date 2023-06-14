package com.br.meupedido.meupedido.web.v1;

import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;
import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.business.services.PedidoReportService;
import com.br.meupedido.meupedido.fixture.PedidoFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoReportService pedidoReportService;

    @Test
    void calculaPedido() throws Exception {

        CalculaPedidoResponse calculaPedidoResponse = PedidoFixture.buildCalcularPedidoResponse();
        when(pedidoReportService.calculaPedido(1L)).thenReturn(calculaPedidoResponse);

        mockMvc.perform(get("/v1/report/pedido?codigoPedido=1001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();

    }
    @Test
    void getQuantidadePedidoPorCliente() throws Exception {
        QuantidadePedidoPorClienteResponse quantidadePedidoPorClienteResponse
                = PedidoFixture.buildQuantidadePedidoPorClienteResponse();
        when(pedidoReportService.getQuantidadePedidoPorCliente(1L)).thenReturn(quantidadePedidoPorClienteResponse);

        mockMvc.perform(get("/v1/report/pedido/quantidade?codigoCliente=11")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }
}