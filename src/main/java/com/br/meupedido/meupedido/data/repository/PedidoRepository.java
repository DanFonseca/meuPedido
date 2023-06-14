package com.br.meupedido.meupedido.data.repository;

import com.br.meupedido.meupedido.data.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findByCodigoPedido(Long codigoPedido);

    List<Pedido> findByClienteId (Long id);
}
