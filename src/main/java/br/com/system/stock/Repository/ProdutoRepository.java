package br.com.system.stock.Repository;

import br.com.system.stock.Model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

    /// Pesquisa por Descrição Ignorando Miuscula e Minuscula
    ///List<Produto> findByDescricaoContainingIgnoreCase(String descricao);
}
