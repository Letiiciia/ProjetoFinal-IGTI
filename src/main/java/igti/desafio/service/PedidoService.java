package igti.desafio.service;

import igti.desafio.modelo.Pedido;
import igti.desafio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
