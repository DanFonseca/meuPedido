package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private Long id;


    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Pedido> pedidos;
}
