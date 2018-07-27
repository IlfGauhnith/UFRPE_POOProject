package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorRepositorio {
    private List<IRepositorio> repositorios;
    private static ControladorRepositorio instance;

    public ControladorRepositorio() {
        repositorios = new ArrayList<>();
        repositorios.add(RepositorioCaminhao.getinstance());
        repositorios.add(RepositorioCliente.getInstance());
        repositorios.add(RepositorioEndereco.getInstance());
        repositorios.add(RepositorioFuncionario.getInstance());
        repositorios.add(RepositorioServico.getInstance());
    }

    public static ControladorRepositorio getInstance() {
        if(instance == null)
            instance = new ControladorRepositorio();

        return instance;
    }

    public void persistAll() {
        for(int i = 0 ; i < repositorios.size() ; i++)
            repositorios.get(i).persist();

        EstoquePecas.getInstance().persist();
    }
}
