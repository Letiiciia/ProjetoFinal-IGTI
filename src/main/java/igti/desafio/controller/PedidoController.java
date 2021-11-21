package igti.desafio.controller;

import igti.desafio.modelo.Pedido;
import igti.desafio.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
            pedido = pedidoService.criarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> pedidoPorId(@PathVariable Integer id) {
        Pedido pedido = pedidoService.pedidoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPorId(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido pedidoAtualizado = pedidoService.atualizarPorId(id,pedido);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoAtualizado);
    }
}
