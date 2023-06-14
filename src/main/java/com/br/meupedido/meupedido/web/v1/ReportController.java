package com.br.meupedido.meupedido.web.v1;

import com.br.meupedido.meupedido.business.response.QuantidadePedidoPorClienteResponse;
import com.br.meupedido.meupedido.business.response.CalculaPedidoResponse;
import com.br.meupedido.meupedido.business.services.PedidoReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/report/pedido")
@Slf4j
public class ReportController {

    private PedidoReportService pedidoReportService;

    public ReportController(PedidoReportService pedidoReportService) {
        this.pedidoReportService = pedidoReportService;
    }

    @GetMapping()
    public CalculaPedidoResponse
    calculaPedido(@RequestParam (value = "codigoPedido") Long codigoPedido) {
        return pedidoReportService.calculaPedido(codigoPedido);
    }

    @GetMapping("/quantidade")
    public QuantidadePedidoPorClienteResponse
    getQuantidadePedidoPorCliente (@RequestParam (value = "codigoCliente") Long codigoCliente) {
        return this.pedidoReportService.getQuantidadePedidoPorCliente(codigoCliente);
    }
}
