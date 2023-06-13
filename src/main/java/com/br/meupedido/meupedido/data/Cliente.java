package com.br.meupedido.meupedido.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cliente implements Serializable {
    @Id
    private Long codigoCliente;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Pedido> pedidos;
}
