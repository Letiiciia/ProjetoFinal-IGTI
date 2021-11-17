package igti.desafio.service;

import igti.desafio.modelo.Produto;
import igti.desafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listaProdutos() {
        try {
            List<Produto> produtos = produtoRepository.findAll();
            return produtos;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Produto produtoPorId(Integer id) {
        try {
            Optional<Produto> produto = produtoRepository.findById(id);
            return  produto.orElseThrow(() ->
                    new RuntimeException("Object Not Found"));
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
