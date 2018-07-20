package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.IRepositorio;
import ufrpe.deinfo.bcc.data.RepositorioCaminhao;
import ufrpe.deinfo.bcc.model.Caminhao;
import ufrpe.deinfo.bcc.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public void criar(String chassi, String placa, String modelo, String fabricante,
                               int ano, Cliente dono) throws IllegalArgumentException {

        if(chassi == null || placa == null || modelo == null || fabricante == null || ano < 1900)
            throw new IllegalArgumentException();
        if(chassi.length() > 17)
            throw new IllegalArgumentException();
        if(placa.length() > 8)
            throw new IllegalArgumentException();
        if(dono == null)
            throw new IllegalArgumentException();

        Caminhao caminhao = new Caminhao(chassi, placa, modelo, ano, fabricante, dono);

        repositorioCaminhao.criar(caminhao);
    }

    public void criar(String chassi, String placa, String modelo, String fabricante,
                              int ano, Cliente dono, LocalDate ultimaManutencao) throws IllegalArgumentException {
        if(chassi == null || placa == null || modelo == null || fabricante == null || ano < 1900)
            throw new IllegalArgumentException();
        if(chassi.length() > 10)
            throw new IllegalArgumentException();
        if(placa.length() > 8)
            throw new IllegalArgumentException();
        if(dono == null)
            throw new IllegalArgumentException();
        if(ultimaManutencao == null)
            throw new IllegalArgumentException();

        Caminhao caminhao = new Caminhao(chassi, placa, modelo, ano, fabricante, ultimaManutencao, dono);

        repositorioCaminhao.criar(caminhao);
    }

    public void remover(String chassi, String placa) throws IllegalArgumentException {
        if(chassi == null || placa == null)
            throw new IllegalArgumentException();

        Caminhao caminhao = new Caminhao(chassi, placa);

        repositorioCaminhao.deletar(caminhao);
    }

    public ArrayList<Caminhao> buscarCaminhao(String chassi, String placa, String modelo, int ano,
                                              String fabricante, Cliente dono) {
        return new ArrayList();
    }

    public ArrayList<Caminhao> buscarTodosCaminhoes() {
        return (ArrayList) repositorioCaminhao.ler();
    }
}
