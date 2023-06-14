package com.br.meupedido.meupedido.business.services.impl;

import com.br.meupedido.meupedido.business.response.ValorTotalPedidoResponse;
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

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public PedidoReportServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public ValorTotalPedidoResponse calcularValorTotalDoPedido(Long codigoDoPedido) {
        Pedido pedido = pedidoRepository.findByCodigoPedido(codigoDoPedido);

        Double valorTotal =  pedido
                .getItens()
                .stream()
                .mapToDouble(Item::getPreco).sum();

        return new ValorTotalPedidoResponse(valorTotal, pedido.getCliente().getCodigoCliente());
    }

    public List<Cliente> getQuantidadePedidoPorCliente(Long codigoCliente) {
        Long id = clienteRepository.findByCodigoCliente(codigoCliente).getId();
        return this.clienteRepository.getQuantidadePedidoPorCliente(id);
    }

}
