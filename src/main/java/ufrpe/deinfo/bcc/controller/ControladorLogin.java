package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioFuncionario;
import ufrpe.deinfo.bcc.model.Funcionario;

public class ControladorLogin {
    private static ControladorLogin instance;
    private RepositorioFuncionario repositorioFuncionario;


    private ControladorLogin() {
        repositorioFuncionario = RepositorioFuncionario.getInstance();
    }

    public static ControladorLogin getInstance() {
        if(instance == null)
            instance = new ControladorLogin();

        return instance;
    }

    public boolean efetuarLogin(String login, String pswd) {
        Funcionario f = new Funcionario(login, pswd);
        boolean auth = false;

        if(repositorioFuncionario.ler().contains(f))
            auth = true;

        return auth;
    }

}
