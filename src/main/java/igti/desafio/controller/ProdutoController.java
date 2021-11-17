package igti.desafio.controller;

import java.util.List;
import igti.desafio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import igti.desafio.modelo.Produto;

@RestController
@Transactional
@RequestMapping("/cardapio")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> listaProdutos() {
		List<Produto> produtos = produtoService.listaProdutos();
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> produtoPorId(@PathVariable Integer id){
		Produto produto  = produtoService.produtoPorId(id);
		return ResponseEntity.ok().body(produto);
	}
}
