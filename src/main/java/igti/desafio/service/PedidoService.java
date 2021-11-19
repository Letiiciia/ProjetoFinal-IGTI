package igti.desafio.service;

import igti.desafio.modelo.Pedido;
import igti.desafio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        try {
        pedido = pedidoRepository.save(pedido);
        return pedido;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pedido> listarPedidos() {
        try {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pedido pedidoPorId(Integer id) {
        try {
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            return pedido.get();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pedido atualizarPorId(Integer id, Pedido pedido) {
        try {
            LocalDateTime dataHora = LocalDateTime.now();
            Optional<Pedido> pedidoAtualizar = pedidoRepository.findById(id);
            pedidoAtualizar.get().setId(id);
            pedidoAtualizar.get().setDataHora(dataHora);
            pedidoAtualizar.get().setSituacao(pedido.getSituacao());
            pedidoAtualizar.get().setItens(pedido.getItens());
            return pedidoAtualizar.get();

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
