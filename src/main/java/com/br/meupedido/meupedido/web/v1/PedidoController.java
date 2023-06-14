package com.br.meupedido.meupedido.web.v1;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import com.br.meupedido.meupedido.business.response.ValorTotalPedidoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pedido")
@Slf4j
public class PedidoController {

    private RabbitTemplate rabbitTemplate;

    @Value("${meuPedido.queueName}")
    private String routingKey;

    public PedidoController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public void criarPedido(@RequestBody PedidoDTO pedidoDTO ) {
        log.info("Enviando Mensagem para criar o pedido {} ", pedidoDTO.codigoPedido());
        rabbitTemplate.convertAndSend(routingKey, pedidoDTO);
        log.info("Mensagem enviada com sucesso parfila {}", routingKey);
    }
}
