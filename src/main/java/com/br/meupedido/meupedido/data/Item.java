package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private Long id;
    @Column
    private int quantidade;
    @Column
    private Double preco;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Pedido pedido;
}
