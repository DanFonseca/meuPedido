package com.br.meupedido.meupedido.business.services.impl;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.excpetion.NotFoundException;
import com.br.meupedido.meupedido.business.services.CriarPedidoService;
import com.br.meupedido.meupedido.data.Cliente;
import com.br.meupedido.meupedido.data.Pedido;
import com.br.meupedido.meupedido.data.repository.ClienteRepository;
import com.br.meupedido.meupedido.data.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CriarPedidoServiceImpl implements CriarPedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteRepository clienteRepository;


    public CriarPedidoServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void criar(PedidoDTO pedidoDTO) {

        if(pedidoRepository.findByCodigoPedido(pedidoDTO.codigoPedido()).isPresent()){
            return;
        }

        Optional <Cliente> cliente =
                clienteRepository.findByCodigoCliente(pedidoDTO.codigoCliente());

        if (cliente.isPresent()) {
            atualizarDadoDoPedido (pedidoDTO, cliente.get());
            return;
        }

        log.info("Criação do Pedido e um novo Cliente");

        Pedido pedido = new Pedido(pedidoDTO, new Cliente(pedidoDTO.codigoCliente()));
        pedidoRepository.saveAndFlush(pedido);

        log.info("Pedido {} Salvo com sucesso!", pedido.getCodigoPedido());
    }

    public void atualizarDadoDoPedido (PedidoDTO pedidoDTO, Cliente cliente) {
        log.info("Cliente já existe na Base de Dados, atualizando o objeto Pedido");

        Pedido pedido = pedidoRepository.saveAndFlush(new Pedido(pedidoDTO, null));
        pedido.setCliente(cliente);
        pedidoRepository.saveAndFlush(pedido);

        log.info("Pedido {} Salvo com sucesso!", pedido.getCodigoPedido());
    }

}
