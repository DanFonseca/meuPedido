package com.br.meupedido.meupedido.web.messagering.consumer;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.services.impl.CriarPedidoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoConsumer {

    private CriarPedidoServiceImpl criarPedidoService;

    public PedidoConsumer(CriarPedidoServiceImpl criarPedidoService) {
        this.criarPedidoService = criarPedidoService;
    }

    @RabbitListener(queues = "${meuPedido.queueName}")
    public void receive (PedidoDTO pedidoDTO){
        log.info("Pedido {} Recebido com Sucesso.", pedidoDTO.codigoPedido());
        log.info("Salvando na base de dados...");
        this.criarPedidoService.save(pedidoDTO);
    }
}
