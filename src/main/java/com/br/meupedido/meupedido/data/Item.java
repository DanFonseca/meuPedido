package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    @Id
    private Long id;
    @Column
    private int quantidade;
    @Column
    private Double preco;
    @Column
    private String produto;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Pedido pedido;
}
