package classes;

import java.util.List;

public interface ProdutoDAO {
    void addProduto(Produto produto) throws DAOException;
    Produto getProdutoById(String produtoId) throws DAOException;
    List<Produto> getAllProdutos() throws DAOException;
    void updateProduto(Produto produto) throws DAOException;
    void deleteProduto(Produto produto) throws DAOException;
}
