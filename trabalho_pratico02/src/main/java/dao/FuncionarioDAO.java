package dao;

import model.Dependente;
import model.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FuncionarioDAO {

    public void adiciona(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            em.merge(funcionario);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Funcionario> getListaJPQL() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> l = em.createQuery("select f from Funcionario as f", Funcionario.class).getResultList();
        return l;
    }

    public List<Funcionario> getListaCriteria() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
        criteriaQuery.from(Funcionario.class);
        List<Funcionario> l = em.createQuery(criteriaQuery).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Funcionario> getListNamedQuery() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> l = em.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
        return l;
    }

    public List<Funcionario> getListaNativeQuery() {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM funcionarios", Funcionario.class);
        List<Funcionario> f = q.getResultList();
        JPAUtil.closeEntityManager();
        return f;
    }

    public void transacaoTresOperacoes() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            Funcionario novoFuncionario = new Funcionario("86184444112", "007", "Caba Func Novo", "caba@new.com", "41418282");
            Funcionario novoFuncionarioSalvo = em.merge(novoFuncionario);
            JPAUtil.commit();

            JPAUtil.beginTransaction();
            Dependente dependente = new Dependente("75074444112", "Fih do Caba Func Novo");
            dependente.setFuncionario(novoFuncionarioSalvo);
            em.merge(dependente);
            JPAUtil.commit();

            JPAUtil.beginTransaction();
            em.remove(novoFuncionarioSalvo);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
