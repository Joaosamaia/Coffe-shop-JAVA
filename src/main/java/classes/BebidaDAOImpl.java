package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BebidaDAOImpl extends Bebida implements BebidaDAO {
    private EntityManager entity;

    public BebidaDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addBebida(Bebida bebida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(bebida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Bebida", e);
        }
    }

    @Override
    public Bebida getBebidaById(String produtoId) throws DAOException {
        try {
            return entity.find(Bebida.class, produtoId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Bebida pelo ID", e);
        }
    }

    @Override
    public List<Bebida> getAllBebidas() throws DAOException {
        try {
            TypedQuery<Bebida> query = entity.createQuery(
                    "SELECT b FROM Bebida b", Bebida.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias de Bebidas", e);
        }
    }

    @Override
    public void updateBebida(Bebida bebida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(bebida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Bebida", e);
        }
    }

    @Override
    public void deleteBebida(Bebida bebida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(bebida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Bebida", e);
        }
    }
}
