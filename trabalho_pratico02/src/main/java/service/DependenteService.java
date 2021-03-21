package service;

import dao.DependenteDAO;
import model.Dependente;

import java.util.List;

public class DependenteService {

    private DependenteDAO dependenteDAO;

    public DependenteService() {
        this.dependenteDAO = new DependenteDAO();
    }

    public List<Dependente> buscaIniciadosPorJPQL(String nome) {
        return dependenteDAO.getListaIniciadoPorJPQL(nome);
    }

    public List<Dependente> buscaIniciadosPorCriteria(String nome) {
        return dependenteDAO.getListaIniciadoPorCriteria(nome);
    }

    public List<Dependente> buscaIniciadosPorNamedQuery(String nome) {
        return dependenteDAO.getListaIniciadoPorNamedQuery(nome);
    }

    public List<Dependente> buscaIniciadosPorNativeQuery(String nome) {
        return dependenteDAO.getListaIniciadoPorNativeQuery(nome);
    }
}
