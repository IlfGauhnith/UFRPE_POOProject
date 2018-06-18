package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioCaminhao;

public class ControladorCaminhao {
    private RepositorioCaminhao repositorioCaminhao;
    private static ControladorCaminhao instance;

    private ControladorCaminhao(){
        repositorioCaminhao = RepositorioCaminhao.getinstance();
    }

    public static ControladorCaminhao getInstance() {
        if(instance == null)
            instance = new ControladorCaminhao();

        return instance;
    }

    public void criarCaminhao() {

    }
}
