package com.br.meupedido.meupedido.business.services.impl;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.services.CriarPedidoService;
import com.br.meupedido.meupedido.data.Cliente;
import com.br.meupedido.meupedido.data.Pedido;
import com.br.meupedido.meupedido.data.repository.ClienteRepository;
import com.br.meupedido.meupedido.data.repository.PedidoRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CriarPedidoServiceImpl implements CriarPedidoService {

    private PedidoRepository pedidoRepository;

    private ClienteRepository clienteRepository;

    private EntityManager em;

    public CriarPedidoServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, EntityManager entityManager) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.em = entityManager;
    }

    public void save (PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(pedidoDTO);
        pedidoRepository.saveAndFlush(pedido);
        log.info("Pedido {} Salvo com sucesso!", pedido.getCodigoPedido());
    }

}
