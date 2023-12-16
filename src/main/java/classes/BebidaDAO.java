package classes;

import java.util.List;

public interface BebidaDAO {
    void addBebida(Bebida bebida) throws DAOException;
    Bebida getBebidaById(String produtoId) throws DAOException;
    List<Bebida> getAllBebidas() throws DAOException;
    void updateBebida(Bebida bebida) throws DAOException;
    void deleteBebida(Bebida bebida) throws DAOException;
}
