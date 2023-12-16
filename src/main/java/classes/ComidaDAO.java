package classes;

import java.util.List;

public interface ComidaDAO {
    void addComida(Comida comida) throws DAOException;
    Comida getComidaById(String produtoId) throws DAOException;
    List<Comida> getAllComidas() throws DAOException;
    void updateComida(Comida comida) throws DAOException;
    void deleteComida(Comida comida) throws DAOException;
}