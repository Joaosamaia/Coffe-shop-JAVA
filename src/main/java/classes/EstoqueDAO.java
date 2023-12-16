package classes;

import java.util.List;

public interface EstoqueDAO {
    void addEstoque(Estoque estoque) throws DAOException;
    Estoque getEstoqueById(String estoqueId) throws DAOException;
    List<Estoque> getAllEstoques() throws DAOException;
    void updateEstoque(Estoque estoque) throws DAOException;
    void deleteEstoque(Estoque estoque) throws DAOException;
}