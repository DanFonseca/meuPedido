package com.br.meupedido.meupedido.data;

import com.br.meupedido.meupedido.business.dto.PedidoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long codigoPedido;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Item> itens;

    public Pedido (PedidoDTO pedidoDTO){
        this.codigoPedido = pedidoDTO.codigoPedido();
        this.cliente = new Cliente(pedidoDTO.codigoCliente());
        this.itens = pedidoDTO.itens().stream().map(Item::new).toList();
    }
}
