package dao;

import model.Dependente;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DependenteDAO {

    public List<Dependente> getListaIniciadoPorJPQL(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Dependente> l = em.createQuery("SELECT d FROM Dependente d WHERE lower(d.nome) LIKE :nome", Dependente.class)
                .setParameter("nome", nome.toLowerCase() + "%").getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Dependente> getListaIniciadoPorCriteria(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Dependente> criteriaQuery = criteriaBuilder.createQuery(Dependente.class);
        Root<Dependente> rootQuery = criteriaQuery.from(Dependente.class);
        criteriaQuery.select(rootQuery)
                .where(criteriaBuilder.like(criteriaBuilder.lower(rootQuery.get("nome")), nome.toLowerCase() + "%"));
        List<Dependente> l = em.createQuery(criteriaQuery).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Dependente> getListaIniciadoPorNamedQuery(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Dependente> l = em.createNamedQuery("Dependente.findByIniciadosPorNome", Dependente.class)
                .setParameter("nome", nome.toLowerCase() + "%")
                .getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Dependente> getListaIniciadoPorNativeQuery(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createNativeQuery("SELECT d.id, d.nome, d.cpf, d.funcionario_id FROM dependentes d WHERE LOWER(d.nome) LIKE :nome", Dependente.class);
        q.setParameter("nome", nome.toLowerCase() + "%");
        List<Dependente> d = q.getResultList();
        JPAUtil.closeEntityManager();
        return d;
    }
}
