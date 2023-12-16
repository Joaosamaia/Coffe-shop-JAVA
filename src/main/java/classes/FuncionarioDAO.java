package classes;

import java.util.List;

public interface FuncionarioDAO {
    void addFuncionario(Funcionario funcionario) throws DAOException;
    Funcionario getFuncionarioById(String pessoaID) throws DAOException;
    List<Funcionario> getAllFuncionarios() throws DAOException;
    void updateFuncionario(Funcionario funcionario) throws DAOException;
    void deleteFuncionario(Funcionario funcionario) throws DAOException;
}
