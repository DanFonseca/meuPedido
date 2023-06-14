package com.br.meupedido.meupedido.business.response;

public record ValorTotalPedidoResponse (
        Double ValorTotalDoPedido,
        Long codigoCliente
) {
}
