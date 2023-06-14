package com.br.meupedido.meupedido.business.response;

public record CalculaPedidoResponse(
        Double ValorTotalDoPedido,
        Long codigoCliente
) {
}
