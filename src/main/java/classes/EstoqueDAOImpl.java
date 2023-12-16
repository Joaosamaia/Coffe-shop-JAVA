package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstoqueDAOImpl extends Endereco implements EstoqueDAO {
    private EntityManager entity;

    public EstoqueDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addEstoque(Estoque estoque) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(estoque);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Estoque", e);
        }
    }

    @Override
    public Estoque getEstoqueById(String estoqueId) throws DAOException {
        try {
            return entity.find(Estoque.class, estoqueId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Estoque pelo ID", e);
        }
    }

    @Override
    public List<Estoque> getAllEstoques() throws DAOException {
        try {
            TypedQuery<Estoque> query = entity.createQuery(
                    "SELECT e FROM Estoque e", Estoque.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de getting all Estoques", e);
        }
    }

    @Override
    public void updateEstoque(Estoque estoque) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(estoque);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Estoque", e);
        }
    }

    @Override
    public void deleteEstoque(Estoque estoque) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(estoque);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Estoque", e);
        }
    }
    
    public void reEstoqueProduto(String produtoID, Integer quantity) throws DAOException {
        try {
            entity.getTransaction().begin();
            Produto produto = entity.find(Produto.class, produtoID);
            if (produto != null) {
                produto.getEstoque().setQuantidade(produto.getEstoque().getQuantidade() + quantity);
                entity.merge(produto);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de re-estocar Produto", e);
        }
    }
    
    public String viewEstoqueDetails(String produtoID) throws DAOException {
        try {
            Produto produto = entity.find(Produto.class, produtoID);

            if (produto != null) {
                return "Detalhes do Estoque:\n" +
                        "Id do produto: " + produto.getProdutoID() + "\n" +
                        "Nome: " + produto.getNome() + "\n" +
                        "Tamanho: " + produto.getEstoque().getQuantidade();
            } else {
                return "Produto nao encontrado no estoque.";
            }
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de ver os detalhes do Estoque", e);
        }
    }
    
    public boolean checkEstoqueAvailability(String produtoID, Integer tamanhoRequisitado) throws DAOException {
        try {
            Produto produto = entity.find(Produto.class, produtoID);
            return produto != null && produto.getEstoque().getQuantidade() >= tamanhoRequisitado;
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de checar a disponibilidade do Estoque", e);
        }
    }

    
    public void adjustEstoqueLevel(String produtoID, Integer novoTamanho) throws DAOException {
        try {
            entity.getTransaction().begin();
            Produto produto = entity.find(Produto.class, produtoID);
            if (produto != null) {
                produto.getEstoque().setQuantidade(novoTamanho);
                entity.merge(produto);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de ajustar o tamanho do Estoque", e);
        }
    }

    
    public String generateEstoqueReport(String dateRange, String categories) throws DAOException {
        try {
            TypedQuery<Produto> query = entity.createQuery(
                    "SELECT p FROM Produto p WHERE p.data >= :startDate AND p.data <= :endDate AND p.categoria IN :categories",
                    Produto.class
            );

            List<Produto> produtos = query.getResultList();

            StringBuilder report = new StringBuilder();

            for (Produto produto : produtos) {
                report.append("ID do Produto: ").append(produto.getProdutoID()).append("\n");
                report.append("Nome: ").append(produto.getNome()).append("\n");
                report.append("Preco: ").append(produto.getPreco()).append("\n");
                report.append("\n");
            }

            return report.toString();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de gerar relatorio de Estoque", e);
        }
    }
}
