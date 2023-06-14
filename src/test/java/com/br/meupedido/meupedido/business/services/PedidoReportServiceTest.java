package com.br.meupedido.meupedido.business.services;

import com.br.meupedido.meupedido.business.excpetion.NotFoundException;
import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;
import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.business.services.impl.CriarPedidoServiceImpl;
import com.br.meupedido.meupedido.business.services.impl.PedidoReportServiceImpl;
import com.br.meupedido.meupedido.data.Pedido;
import com.br.meupedido.meupedido.data.repository.ClienteRepository;
import com.br.meupedido.meupedido.data.repository.PedidoRepository;
import com.br.meupedido.meupedido.fixture.PedidoFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class PedidoReportServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CriarPedidoServiceImpl criarPedidoService;
    @InjectMocks
    private PedidoReportServiceImpl pedidoReportService;

    @Test
    public void testCalculaPedido() {
        Pedido pedido = PedidoFixture.buildPedido();

        Mockito.when(pedidoRepository.findByCodigoPedido(1L))
                .thenReturn(Optional.of(pedido));
        Mockito.when(clienteRepository.findByCodigoCliente(1L))
                .thenReturn(Optional.of(pedido.getCliente()));

        CalculaPedidoResponse calculaPedidoResponse = pedidoReportService.calculaPedido(1L);

        assertEquals(calculaPedidoResponse.ValorTotalDoPedido(), 30.0);
    }


    @Test
    public void testGetQuantidadePedidoPorCliente() {
        Pedido pedido = PedidoFixture.buildPedido();

        Mockito.when(clienteRepository.findByCodigoCliente(any()))
                .thenReturn(Optional.of(pedido.getCliente()));

        Mockito.when(pedidoRepository.findByClienteId(pedido.getCliente().getId()))
                .thenReturn(List.of(pedido, pedido));

        QuantidadePedidoPorClienteResponse quantidadePedidoPorClienteResponse =
                pedidoReportService.getQuantidadePedidoPorCliente(1L);

        assertEquals(2, quantidadePedidoPorClienteResponse.quantidadeTotalDePedidos());
    }

    @Test
    void testCalculaPedidoNotFound() {
        Long codigoDoPedido = 123L;

        Mockito.when(pedidoRepository.findByCodigoPedido(codigoDoPedido))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> pedidoReportService.calculaPedido(codigoDoPedido));
    }

    @Test
    void testGetQuantidadePedidoPorClienteNotFound() {
        Long codigoCliente = 123L;

        Mockito.when(clienteRepository.findByCodigoCliente(codigoCliente))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> pedidoReportService.getQuantidadePedidoPorCliente(codigoCliente));
    }

}