package com.br.meupedido.meupedido.business.dto;

import com.br.meupedido.meupedido.data.Item;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public record PedidoDTO (
        @JsonProperty("codigoPedido")
        Long codigoPedido,
        @JsonProperty("codigoCliente")
        Long codigoCliente,
        List<ItemDTO> itens
) implements Serializable {
}
