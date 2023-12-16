package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FornecedorDAOImpl extends Fornecedor implements FornecedorDAO {
    private EntityManager entity;

    public FornecedorDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addFornecedor(Fornecedor fornecedor) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(fornecedor);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Fornecedor", e);
        }
    }

    @Override
    public Fornecedor getFornecedorByCnpj(String cnpj) throws DAOException {
        try {
            return entity.find(Fornecedor.class, cnpj);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Fornecedor pelo CNPJ", e);
        }
    }

    @Override
    public List<Fornecedor> getAllFornecedores() throws DAOException {
        try {
            TypedQuery<Fornecedor> query = entity.createQuery(
                    "SELECT f FROM Fornecedor f", Fornecedor.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias Fornecedores", e);
        }
    }

    @Override
    public void updateFornecedor(Fornecedor fornecedor) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(fornecedor);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Fornecedor", e);
        }
    }

    @Override
    public void deleteFornecedor(Fornecedor fornecedor) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(fornecedor);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Fornecedor", e);
        }
    }
}