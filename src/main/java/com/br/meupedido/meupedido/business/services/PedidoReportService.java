package com.br.meupedido.meupedido.business.services;

import com.br.meupedido.meupedido.business.response.ValorTotalPedidoResponse;
import com.br.meupedido.meupedido.data.Cliente;

import java.util.List;

public interface PedidoReportService {
     ValorTotalPedidoResponse calcularValorTotalDoPedido (Long codigoDoPedido);
     List<Cliente> getQuantidadePedidoPorCliente(Long codigoCliente);

}
