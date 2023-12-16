package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PedidoDAOImpl extends Pedido implements PedidoDAO {
    private EntityManager entity;

    public PedidoDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addPedido(Pedido pedido) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(pedido);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Pedido", e);
        }
    }

    @Override
    public Pedido getPedidoById(String pedidoId) throws DAOException {
        try {
            return entity.find(Pedido.class, pedidoId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Pedido pelo ID", e);
        }
    }

    @Override
    public List<Pedido> getAllPedidos() throws DAOException {
        try {
            TypedQuery<Pedido> query = entity.createQuery(
                    "SELECT p FROM Pedido p", Pedido.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de getting all Pedidos", e);
        }
    }

    @Override
    public void updatePedido(Pedido pedido) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(pedido);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Pedido", e);
        }
    }

    @Override
    public void deletePedido(Pedido pedido) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(pedido);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Pedido", e);
        }
    }

    public Pedido viewOrderDetails(String pedidoId) throws DAOException {
        try {
            return entity.find(Pedido.class, pedidoId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de visualizar os detalhes do Pedido", e);
        }
    }

    public Double calculateTotal(String pedidoId) throws DAOException {
        try {
            TypedQuery<Double> query = entity.createQuery(
                    "SELECT SUM(p.preco) FROM Pedido pedido JOIN pedido.produto p WHERE pedido.pedidoID = :pedidoId",
                    Double.class);
            query.setParameter("pedidoId", pedidoId);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de calcular o valor total do Pedido", e);
        }
    }

    public String generateNotinha(String pedidoId) throws DAOException {
        try {
            Pedido pedido = entity.find(Pedido.class, pedidoId);
            if (pedido == null) {
                return "Dados do Pedido invalidos. Incapaz de gerar notinha para o pedido.";
            }
    
            StringBuilder receipt = new StringBuilder();
            receipt.append("Receipt for Order ID: ").append(pedido.getPedidoID()).append("\n");
            receipt.append("Date and Time: ").append(pedido.getDataHora()).append("\n");
            receipt.append("Total Value: $").append(calculateTotal(pedidoId)).append("\n");

            List<Produto> produtos = pedido.getProduto();
            if (produtos != null && !produtos.isEmpty()) {
                receipt.append("Items Ordered:\n");
    
                for (Produto produto : produtos) {
                    receipt.append("- ").append(produto.getNome()).append(" (ID: ").append(produto.getProdutoID())
                            .append(", Price: $").append(produto.getPreco()).append(")\n");
                }
            }
            return receipt.toString();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de gerar notinha para o Pedido", e);
        }
    }

}
