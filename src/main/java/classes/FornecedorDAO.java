package classes;

import java.util.List;

public interface FornecedorDAO {
    void addFornecedor(Fornecedor fornecedor) throws DAOException;
    Fornecedor getFornecedorByCnpj(String cnpj) throws DAOException;
    List<Fornecedor> getAllFornecedores() throws DAOException;
    void updateFornecedor(Fornecedor fornecedor) throws DAOException;
    void deleteFornecedor(Fornecedor fornecedor) throws DAOException;
}
