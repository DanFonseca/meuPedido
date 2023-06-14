package com.br.meupedido.meupedido.fixture;

import com.br.meupedido.meupedido.business.dto.ItemDTO;
import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;
import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.data.Cliente;
import com.br.meupedido.meupedido.data.Item;
import com.br.meupedido.meupedido.data.Pedido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PedidoFixture {


    public static Pedido buildPedido () {
        Pedido pedido = new Pedido();
        pedido.setCodigoPedido(1L);
        Cliente cliente = new Cliente(1L);
        pedido.setCliente(cliente);
        pedido.setItens(
                Arrays.asList(
                        new Item(new ItemDTO(1, 10.0, "Item 1")),
                        new Item(new ItemDTO(2, 20.0, "Item 2")))
        );

        return pedido;
    }

    public static PedidoDTO buildPedidoDTO () {
        List<ItemDTO> itens = new ArrayList<>();
        itens.add(new ItemDTO(1, 1.0, "Produto Teste"));
        return new PedidoDTO(1L, 123L, itens);
    }

    public static CalculaPedidoResponse buildCalcularPedidoResponse () {
        return new CalculaPedidoResponse (
                1.0,
                1L
        );
    }

    public static QuantidadePedidoPorClienteResponse buildQuantidadePedidoPorClienteResponse () {
        return new QuantidadePedidoPorClienteResponse (
                1,
                List.of(buildPedido())
        );
    }
}
