package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pedido implements Serializable {
    @Id
    private Long codigoPedido;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Item> itens;
}
