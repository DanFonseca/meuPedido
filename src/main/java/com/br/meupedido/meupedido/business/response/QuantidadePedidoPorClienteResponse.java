package com.br.meupedido.meupedido.business.response;

import com.br.meupedido.meupedido.data.Pedido;

import java.util.List;

public record  QuantidadePedidoPorClienteResponse (
        int quantidadeTotalDePedidos,
        List<Pedido> pedidos
) {
}
