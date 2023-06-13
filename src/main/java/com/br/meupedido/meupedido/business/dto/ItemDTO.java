package com.br.meupedido.meupedido.business.dto;

import java.io.Serializable;

public record ItemDTO(
        int quantidade,
        Double preco,
        String produto
) implements Serializable {
}
