package com.br.meupedido.meupedido.data;

import com.br.meupedido.meupedido.business.dto.ItemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private int quantidade;
    @Column
    private Double preco;
    @Column
    private String produto;

    @ManyToOne(fetch= FetchType.EAGER)
    @JsonIgnore
    private Pedido pedido;

    public Item (ItemDTO itemDTO) {
        this.quantidade = itemDTO.quantidade();
        this.preco = itemDTO.preco();
        this.produto = itemDTO.produto();
    }
}
