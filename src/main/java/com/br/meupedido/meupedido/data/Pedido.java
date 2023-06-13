package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    private Long codigoPedido;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Item> itens;
}
