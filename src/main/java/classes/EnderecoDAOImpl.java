package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EnderecoDAOImpl extends Endereco implements EnderecoDAO {
    private EntityManager entity;

    public EnderecoDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addEndereco(Endereco endereco) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(endereco);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Endereco", e);
        }
    }

    @Override
    public Endereco getEnderecoByCEP(String cep) throws DAOException {
        try {
            TypedQuery<Endereco> query = entity.createQuery(
                    "SELECT e FROM Endereco e WHERE e.cep = :cep", Endereco.class);
            query.setParameter("cep", cep);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Endereco pelo CEP", e);
        }
    }

    @Override
    public List<Endereco> getAllEnderecos() throws DAOException {
        try {
            TypedQuery<Endereco> query = entity.createQuery(
                    "SELECT e FROM Endereco e", Endereco.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias de Enderecos", e);
        }
    }

    @Override
    public void updateEndereco(Endereco endereco) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(endereco);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Endereco", e);
        }
    }

    @Override
    public void deleteEndereco(Endereco endereco) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(endereco);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Endereco", e);
        }
    }
}
