package com.br.meupedido.meupedido.web.messagering.consumer;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoConsumer {

    @RabbitListener(queues = "${meuPedido.queueName}")
    public void receive (PedidoDTO pedidoDTO){
        log.info("Pedido {} Recebido com Sucesso.", pedidoDTO.codigoPedido());
    }
}
