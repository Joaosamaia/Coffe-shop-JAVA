package classes;

import java.util.List;

public interface ClienteDAO {
    void addCliente(Cliente cliente) throws DAOException;
    Cliente getClienteById(String pessoaID) throws DAOException;
    List<Cliente> getAllClientes() throws DAOException;
    void updateCliente(Cliente cliente) throws DAOException;
    void deleteCliente(Cliente cliente) throws DAOException;
}
