package com.br.meupedido.meupedido.data.repository;

import com.br.meupedido.meupedido.data.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
