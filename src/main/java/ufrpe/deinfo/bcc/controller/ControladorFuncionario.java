package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioFuncionario;
import ufrpe.deinfo.bcc.model.Funcionario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public String obterCargoFuncionario(Funcionario f) {
        if(repositorioFuncionario.ler().contains(f)) {
            return (repositorioFuncionario.ler().get(repositorioFuncionario.ler().indexOf(f)).getCargo());
        }

        return null;
    }

    public void criar(String nome, String cod, String cargo, String login, String senha) throws IllegalArgumentException {
        if(!nome.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("Nome não pode conter números");
        else if(nome == null)
            throw new IllegalArgumentException("Nome nulo");
        else if(cod == null)
            throw new IllegalArgumentException("Código nulo");
        else if(cargo == null)
            throw new IllegalArgumentException("Cargo nulo");
        else if(login == null)
            throw new IllegalArgumentException("Login nulo");
        else if(senha == null)
            throw new IllegalArgumentException("Senha nula");

        Funcionario o = new Funcionario(nome, cod, cargo, login, senha);
        repositorioFuncionario.criar(o);
    }

    public List<String> listarNomesPorCargo(String cargo) {
        List<String> nomes = new ArrayList<>();
        for(Funcionario f : repositorioFuncionario.ler())
            if(f.getCargo().equals(cargo))
                nomes.add(f.getNome());

        return nomes;
    }

    public String getCargoMecanicoChefe() {
        return "Mecanico Chefe";
    }

    public String getCargoMecanicoAssistente() {
        return "Mecanico Assistente";
    }

    public Funcionario buscarPorNome(String nome) {
        for(Funcionario f : repositorioFuncionario.ler())
            if(f.getNome().equals(nome))
                return f;

        return null;
    }

    public boolean funcionarioExiste(Funcionario f) {
        return repositorioFuncionario.ler().contains(f);
    }
}
