package com.br.meupedido.meupedido.business.services;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.services.impl.CriarPedidoServiceImpl;
import com.br.meupedido.meupedido.data.Cliente;
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

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CriarPedidoServiceTest {
    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private CriarPedidoServiceImpl criarPedidoService;

    @Test
    public void deveCriarUmPedidoQuandoNaoRetornarNenhumClienteExistente() {
        PedidoDTO pedidoDTO = PedidoFixture.buildPedidoDTO();

        Mockito.when(clienteRepository
                .findByCodigoCliente(pedidoDTO.codigoCliente())).thenReturn(Optional.empty());
        Mockito.when(pedidoRepository
                .saveAndFlush(any())).thenReturn(null);
        Mockito.when(pedidoRepository
                .findByCodigoPedido(any())).thenReturn(Optional.empty());



        criarPedidoService.criar(pedidoDTO);

        Mockito.verify(pedidoRepository, Mockito.times(1)).saveAndFlush(any(Pedido.class));
    }

    @Test
    public void deveCriarUmPedidoQuandoNaoRetornarUmClienteExistente() {
        PedidoDTO pedidoDTO = PedidoFixture.buildPedidoDTO();
        Cliente cliente = new Cliente(1L);

        Mockito.when(clienteRepository.findByCodigoCliente(pedidoDTO.codigoCliente()))
                .thenReturn(Optional.of(cliente));
        Mockito.when(pedidoRepository.saveAndFlush(any())).thenReturn(new Pedido());
        criarPedidoService.criar(pedidoDTO);
        Mockito.when(pedidoRepository
                .findByCodigoPedido(any())).thenReturn(Optional.empty());

        Mockito.verify(pedidoRepository, Mockito.times(2)).saveAndFlush(any(Pedido.class));
    }
}