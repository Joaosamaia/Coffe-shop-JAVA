package classes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDAOImpl extends Funcionario implements FuncionarioDAO {
    private EntityManager entity;

    public FuncionarioDAOImpl(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public void addFuncionario(Funcionario funcionario) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.persist(funcionario);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de adicionar Funcionario", e);
        }
    }

    @Override
    public Funcionario getFuncionarioById(String cpf) throws DAOException {
        try {
            return entity.find(Funcionario.class, cpf);
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar Funcionario pelo ID", e);
        }
    }

    @Override
    public List<Funcionario> getAllFuncionarios() throws DAOException {
        try {
            TypedQuery<Funcionario> query = entity.createQuery(
                    "SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de buscar todas instancias de Funcionarios", e);
        }
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.merge(funcionario);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de atualizar Funcionario", e);
        }
    }

    @Override
    public void deleteFuncionario(Funcionario funcionario) throws DAOException {
        try {
            entity.getTransaction().begin();
            entity.remove(funcionario);
            entity.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de excluir Funcionario", e);
        }
    }
    
    // ViewFuncionarioDetails method
    public String viewFuncionarioDetails(String cpf) throws DAOException {
        try {
            Funcionario funcionario = entity.find(Funcionario.class, cpf);

            if (funcionario != null) {
                return "Detalhes do Funcionario:\n" +
                        "CPF do Funcionario: " + funcionario.getCPF() + "\n" +
                        "Nome: " + funcionario.getNome() + "\n" +
                        "Email: " + funcionario.getEmail() + "\n";
            } else {
                return "Funcionario não encontrado.";
            }
        } catch (Exception e) {
            throw new DAOException("Erro! Incapaz de exibir os detalhes do Funcionario", e);
        }
    }

    // AssignRole method
    public void atribuirCargo(String cpf, String novoCargo) throws DAOException {
        try {
            entity.getTransaction().begin();
            
            // Fetch the Funcionario
            Funcionario funcionario = getFuncionarioById(cpf);
            
            if (funcionario != null) {
                // Update the role
                funcionario.setCargo(novoCargo);
                
                // Merge the changes
                entity.merge(funcionario);
                
                entity.getTransaction().commit();
            } else {
                System.out.println("Funcionario de CPF: " + cpf + " nao encontrado.");
            }
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            throw new DAOException("Erro! Incapaz de atribuir o cargo ao Funcionario", e);
        }
    }
}
