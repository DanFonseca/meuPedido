package com.br.meupedido.meupedido.business.services.impl;

import com.br.meupedido.meupedido.business.excpetion.NotFoundException;
import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;
import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.business.services.PedidoReportService;
import com.br.meupedido.meupedido.data.Cliente;
import com.br.meupedido.meupedido.data.Item;
import com.br.meupedido.meupedido.data.Pedido;
import com.br.meupedido.meupedido.data.repository.ClienteRepository;
import com.br.meupedido.meupedido.data.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PedidoReportServiceImpl implements PedidoReportService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoReportServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public CalculaPedidoResponse calculaPedido(Long codigoDoPedido) {
        Pedido pedido = pedidoRepository.findByCodigoPedido(codigoDoPedido)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));;

        Double valorTotal = pedido
                .getItens()
                .stream()
                .mapToDouble(Item::getPreco).sum();

        return new CalculaPedidoResponse(valorTotal, pedido.getCliente().getCodigoCliente());
    }

    public QuantidadePedidoPorClienteResponse getQuantidadePedidoPorCliente(Long codigoCliente) {
        Cliente cliente = clienteRepository.findByCodigoCliente(codigoCliente)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));;

        List<Pedido> pedidos = pedidoRepository.findByClienteId(cliente.getId());

        return new QuantidadePedidoPorClienteResponse(
                pedidos.size(),
                pedidos
        );
    }

}
