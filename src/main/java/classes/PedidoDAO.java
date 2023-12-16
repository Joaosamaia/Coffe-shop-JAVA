package classes;

import java.util.List;

public interface PedidoDAO {
    void addPedido(Pedido pedido) throws DAOException;
    Pedido getPedidoById(String pedidoId) throws DAOException;
    List<Pedido> getAllPedidos() throws DAOException;
    void updatePedido(Pedido pedido) throws DAOException;
    void deletePedido(Pedido pedido) throws DAOException;
}
