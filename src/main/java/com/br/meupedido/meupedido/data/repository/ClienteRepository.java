package com.br.meupedido.meupedido.data.repository;

import com.br.meupedido.meupedido.data.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCodigoCliente (Long id);
}
