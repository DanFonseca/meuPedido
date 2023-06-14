package com.br.meupedido.meupedido.business.services;

import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;

public interface PedidoReportService {
     CalculaPedidoResponse calculaPedido(Long codigoDoPedido);
     QuantidadePedidoPorClienteResponse getQuantidadePedidoPorCliente(Long codigoCliente);

}
