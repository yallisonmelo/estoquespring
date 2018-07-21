package br.com.system.stock.Endpoint;

import br.com.system.stock.Erro.ResourceNotFoundException;
import br.com.system.stock.Model.Produto;
import br.com.system.stock.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class ProdutoEndpoint {

    // Variavel que Vai Acessar o Banco
    private final ProdutoRepository produtoDAO;

    //Construtor Que tem que ser criado pelo fato da variavel ser Final
    @Autowired
    public ProdutoEndpoint(ProdutoRepository produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    //Retorna a Lista de Todos os Produtos 
    @GetMapping(path = "produtos")
    public ResponseEntity<?> ListaTodosProdutos(Pageable pageable) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(produtoDAO.findAll(pageable), httpHeaders, HttpStatus.OK);
    }

    //Cadastra Produtos no Sistema
    @PostMapping(path = "produtos")
    public ResponseEntity<?> CadastrarProduto(@RequestBody Produto objProduto) {
        return new ResponseEntity<>(produtoDAO.save(objProduto), HttpStatus.CREATED);
    }

    //Altera Dados do Produto
    @PutMapping(path = "produtos")
    public ResponseEntity<?> AlterarProduto(@RequestBody Produto objProduto) {
        VerificaSeProdutoExiste(objProduto.getId());
        produtoDAO.save(objProduto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "produtos/{id}")
    public ResponseEntity<?> DeletarProduto(@PathVariable Long id) {
        VerificaSeProdutoExiste(id);
        produtoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    private void VerificaSeProdutoExiste(Long id) {
        Produto objProduto = produtoDAO.findById(id).orElse(null);
        if (objProduto == null) {
            throw new ResourceNotFoundException("Exclusao Nao Efeutada no Produto de ID: " + id);
        } else {
        }
    }

}
