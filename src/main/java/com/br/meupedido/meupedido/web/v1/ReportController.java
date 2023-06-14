package com.br.meupedido.meupedido.web.v1;

import com.br.meupedido.meupedido.business.response.ValorTotalPedidoResponse;
import com.br.meupedido.meupedido.business.services.PedidoReportService;
import com.br.meupedido.meupedido.data.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/report")
@Slf4j
public class ReportController {

    private PedidoReportService pedidoReportService;

    public ReportController(PedidoReportService pedidoReportService) {
        this.pedidoReportService = pedidoReportService;
    }

    @GetMapping("/valor-total")
    public ValorTotalPedidoResponse calcularValorTotal (Long id) {
        return  pedidoReportService.calcularValorTotalDoPedido(id);
    }

    @GetMapping("/pedido/cliente/{codigoCliente}")
    public List<Cliente> getQuantidadePedidoPorCliente (@PathVariable Long codigoCliente) {
        return this.pedidoReportService.getQuantidadePedidoPorCliente(codigoCliente);
    }
}
