import model.Dependente;
import model.Funcionario;
import service.DependenteService;
import service.FuncionarioService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FuncionarioService funcionarioService = new FuncionarioService();
        DependenteService dependenteService = new DependenteService();
        //funcionarioService.inicializaFuncionaios();
        String iniciados = "jo";
        System.out.println("BUSCA DEPENDENTES INICIADOS POR: " + iniciados);
        System.out.println("JPQL");
        List<Dependente> dependentesJPQL = dependenteService.buscaIniciadosPorJPQL(iniciados);
        System.out.println(dependentesJPQL.toString());

        System.out.println("Criteria");
        List<Dependente> dependentesCriteria = dependenteService.buscaIniciadosPorCriteria(iniciados);
        System.out.println(dependentesCriteria.toString());

        System.out.println("NamedQuery");
        List<Dependente> dependentesNQ = dependenteService.buscaIniciadosPorNamedQuery(iniciados);
        System.out.println(dependentesNQ.toString());

        System.out.println("NativeQuery");
        List<Dependente> dependentesNativeQ = dependenteService.buscaIniciadosPorNativeQuery(iniciados);
        System.out.println(dependentesNativeQ.toString());

        System.out.println();
        System.out.println("LISTAR TODOS OS FUNCIONARIOS");
        System.out.println("JPQL");
        List<Funcionario> funcionariosJPQL = funcionarioService.getListaJQPL();
        for (Funcionario funcionario: funcionariosJPQL) {
            System.out.println(funcionario);
        }

        System.out.println("Criteria");
        List<Funcionario> funcionariosCriteria = funcionarioService.getListaCriteria();
        for (Funcionario funcionario: funcionariosCriteria) {
            System.out.println(funcionario);
        }

        System.out.println("NamedQuery");
        List<Funcionario> funcionariosNQ = funcionarioService.getListaNamedQuery();
        for (Funcionario funcionario: funcionariosNQ) {
            System.out.println(funcionario);
        }

        System.out.println("NativeQuery");
        List<Funcionario> funcionariosNativeQ = funcionarioService.getListaNativeQuery();
        for (Funcionario funcionario: funcionariosNativeQ) {
            System.out.println(funcionario);
        }

        System.out.println();
        System.out.println("REALIZANDO A TRANSACAO COM TRES OPERACOES");
        funcionarioService.transacaoTresOperacoes();

    }

}
