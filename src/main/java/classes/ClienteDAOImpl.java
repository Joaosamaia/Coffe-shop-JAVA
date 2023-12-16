package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAOImpl extends Cliente implements ClienteDAO {
    private EntityManager entity;

    public ClienteDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addCliente(Cliente cliente) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(cliente);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Cliente", e);
        }
    }

    @Override
    public Cliente getClienteById(String clienteID) throws DAOException {
        try {
            return entity.find(Cliente.class, clienteID);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Cliente pelo ID", e);
        }
    }

    @Override
    public List<Cliente> getAllClientes() throws DAOException {
        try {
            TypedQuery<Cliente> query = entity.createQuery(
                    "SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias de Clientes", e);
        }
    }

    @Override
    public void updateCliente(Cliente cliente) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(cliente);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Cliente", e);
        }
    }

    @Override
    public void deleteCliente(Cliente cliente) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(cliente);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Cliente", e);
        }
    }

    public String viewClienteDetails(String clienteID) throws DAOException {
        try {
            Cliente cliente = entity.find(Cliente.class, clienteID);

            if (cliente != null) {
                return "Detalhes do cliente:\n" +
                        "Id do cliente: " + cliente.getClienteID() + "\n" +
                        "Nome: " + cliente.getNome() + "\n" +
                        "Email: " + cliente.getEmail() + "\n" +
                        "Historico de pedidos: \n" + viewOrderHistory(clienteID);
            } else {
                return "Cliente não encontrado.";
            }
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de exibir os detalhes do cliente", e);
        }
    }

    public void placeOrder(String clienteID, List<Produto> produtos) throws DAOException {
        try {
            entity.getTransaction().begin();
            Cliente cliente = entity.find(Cliente.class, clienteID);

            if (cliente != null) {
                Pedido pedido = new Pedido();
                pedido.setCliente(cliente);
                pedido.setProduto(produtos);

                entity.persist(pedido);
            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de efetuar o pedido para o cliente", e);
        }
    }

    public String viewOrderHistory(String clienteID) throws DAOException {
        try {
            TypedQuery<Pedido> query = entity.createQuery(
                    "SELECT p FROM Pedido p WHERE p.cliente.clienteID = :clienteID",
                    Pedido.class
            );
            query.setParameter("Id do cliente", clienteID);

            List<Pedido> orders = query.getResultList();

            StringBuilder orderHistory = new StringBuilder();
            orderHistory.append("Historico de pedidos:\n");

            for (Pedido pedido : orders) {
                orderHistory.append("Id do pedido: ").append(pedido.getPedidoID()).append("\n");
                // Include other relevant information
                orderHistory.append("\n");
            }

            return orderHistory.toString();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de visualizar Historico de pedidos", e);
        }
    }
}
