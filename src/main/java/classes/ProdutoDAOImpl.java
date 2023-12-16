package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDAOImpl extends Produto implements ProdutoDAO {
    private EntityManager entity;

    public ProdutoDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addProduto(Produto produto) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(produto);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Produto", e);
        }
    }

    @Override
    public Produto getProdutoById(String produtoId) throws DAOException {
        try {
            return entity.find(Produto.class, produtoId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Produto pelo ID", e);
        }
    }

    @Override
    public List<Produto> getAllProdutos() throws DAOException {
        try {
            TypedQuery<Produto> query = entity.createQuery(
                    "SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias Produtos", e);
        }
    }

    @Override
    public void updateProduto(Produto produto) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(produto);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Produto", e);
        }
    }

    @Override
    public void deleteProduto(Produto produto) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(produto);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Produto", e);
        }
    }
}
