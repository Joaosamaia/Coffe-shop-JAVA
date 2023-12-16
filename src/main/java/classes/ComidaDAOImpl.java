package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ComidaDAOImpl extends Comida implements ComidaDAO {
    private EntityManager entity;

    public ComidaDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addComida(Comida comida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(comida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Comida", e);
        }
    }

    @Override
    public Comida getComidaById(String produtoId) throws DAOException {
        try {
            return entity.find(Comida.class, produtoId);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Comida pelo ID", e);
        }
    }

    @Override
    public List<Comida> getAllComidas() throws DAOException {
        try {
            TypedQuery<Comida> query = entity.createQuery(
                    "SELECT c FROM Comida c", Comida.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias de Comidas", e);
        }
    }

    @Override
    public void updateComida(Comida comida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(comida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Comida", e);
        }
    }

    @Override
    public void deleteComida(Comida comida) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(comida);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Comida", e);
        }
    }
}
