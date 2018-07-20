package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioFuncionario;
import ufrpe.deinfo.bcc.model.Funcionario;

import java.util.HashSet;

public class ControladorFuncionario {
    private static ControladorFuncionario instance;
    private RepositorioFuncionario repositorioFuncionario;

    private ControladorFuncionario() {
        repositorioFuncionario = RepositorioFuncionario.getInstance();
    }

    public static ControladorFuncionario getInstance() {
        if(instance == null)
            instance = new ControladorFuncionario();

        return instance;
    }

    public int obterCargoFuncionario(Funcionario f) {
        if(repositorioFuncionario.ler().contains(f)) {
            return (repositorioFuncionario.ler().get(repositorioFuncionario.ler().indexOf(f)).getCargo());
        }

        return -1;
    }
}
