package classes;

import java.util.List;

public interface EnderecoDAO {
    void addEndereco(Endereco endereco) throws DAOException;
    Endereco getEnderecoByCEP(String cep) throws DAOException;
    List<Endereco> getAllEnderecos() throws DAOException;
    void updateEndereco(Endereco endereco) throws DAOException;
    void deleteEndereco(Endereco endereco) throws DAOException;
}