package com.br.meupedido.meupedido.data.repository;

import com.br.meupedido.meupedido.data.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c inner join Pedido p on c.id = :cliente_id")
    List<Cliente> getQuantidadePedidoPorCliente (@Param("cliente_id") Long clienteId);

    Cliente findByCodigoCliente (Long id);
}
