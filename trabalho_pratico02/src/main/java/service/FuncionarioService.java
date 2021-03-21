package service;

import dao.FuncionarioDAO;
import model.Dependente;
import model.Funcionario;

import java.util.List;

public class FuncionarioService {

    private FuncionarioDAO funcionarioDAO;

    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public List<Funcionario> getListaJQPL() {
        return funcionarioDAO.getListaJPQL();
    }

    public List<Funcionario> getListaCriteria() {
        return funcionarioDAO.getListaCriteria();
    }

    public List<Funcionario> getListaNamedQuery() {
        return funcionarioDAO.getListNamedQuery();
    }

    public List<Funcionario> getListaNativeQuery() {
        return funcionarioDAO.getListaNativeQuery();
    }

    public void transacaoTresOperacoes() {
        funcionarioDAO.transacaoTresOperacoes();
    }

    public void inicializaFuncionaios() {
        Funcionario f1, f2, f3, f4, f5, f6;
        f1 = new Funcionario("34234234143", "001", "Juao Snow", "joao@snow.com", "69696969");
        Dependente d1joao = new Dependente("12345678911", "Ygritinha da Silva Snow");
        Dependente d2joao = new Dependente("98765432111", "Joazim JR");
        Dependente d3joao = new Dependente("88865432111", "Joy Snow");
        d1joao.setFuncionario(f1);
        d2joao.setFuncionario(f1);
        d3joao.setFuncionario(f1);
        f1.adicionaDependente(d1joao);
        f1.adicionaDependente(d2joao);
        f1.adicionaDependente(d3joao);

        f2 = new Funcionario("38164654038", "002", "Anne With an E Shirlley Cuttberg", "anne@withane.org", "81818844");
        Dependente d1anne = new Dependente("74747477711", "Gilberta Cuttberg");
        Dependente d2anne = new Dependente("88414141111", "Ana Louise Cuttberg");
        d1anne.setFuncionario(f2);
        d2anne.setFuncionario(f2);
        f2.adicionaDependente(d1anne);
        f2.adicionaDependente(d2anne);

        f3 = new Funcionario("56955725735", "003", "Sheldu Lee Cuuper", "sheldu@cuuper.sciency", "88888888");
        Dependente dsheldu = new Dependente("54540654545", "Shamy Lee Silva");
        dsheldu.setFuncionario(f3);
        f3.adicionaDependente(dsheldu);

        f4 = new Funcionario("26856865845", "004", "Ramundu Nonato de Sosa", "ramundu@nonaty.com", "64065055");
        f5 = new Funcionario("98237648734", "005", "Marcus Paulus Schimit", "mp@gmail.com", "56406044");
        f6 = new Funcionario("84606565406", "006", "Luis Pereira", "lp@gmail.com", "83818281");
    }

}
