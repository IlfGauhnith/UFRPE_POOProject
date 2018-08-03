package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.IRepositorio;
import ufrpe.deinfo.bcc.data.RepositorioCaminhao;
import ufrpe.deinfo.bcc.model.Caminhao;
import ufrpe.deinfo.bcc.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorCaminhao {
    private RepositorioCaminhao repositorioCaminhao;
    private static ControladorCaminhao instance;
    private static ControladorCliente controladorCliente;

    private ControladorCaminhao(){
        repositorioCaminhao = RepositorioCaminhao.getinstance();
        controladorCliente = ControladorCliente.getInstance();
    }

    public static ControladorCaminhao getInstance() {
        if(instance == null)
            instance = new ControladorCaminhao();

        return instance;
    }

    public void criar(String chassi, String placa, String modelo, String fabricante,
                               int ano, Cliente dono, long kilometragem) throws IllegalArgumentException {
        if(chassi == null || chassi.length() != 17)
            throw new IllegalArgumentException("O código de chassi deve conter 17 dígitos");

        else if(placa == null || placa.length() != 7)
            throw new IllegalArgumentException("A placa deve conter 7 dígitos");

        else if(modelo == null)
            throw new IllegalArgumentException("Modelo inválido");

        else if(fabricante == null)
            throw new IllegalArgumentException("Fabricante inválido");

        else if(ano < 1900)
            throw new IllegalArgumentException("Ano inválido");

        else if(dono == null)
            throw new  IllegalArgumentException("Dono inválido");

        else if(kilometragem < 0)
            throw new IllegalArgumentException("Kilometragem não pode ser negativa");

        Caminhao caminhao = new Caminhao(chassi, placa, modelo, ano, fabricante, dono, kilometragem);

        repositorioCaminhao.criar(caminhao);
    }

    public void criar(String chassi, String placa, String modelo, String fabricante,
                              int ano, Cliente dono, LocalDate ultimaManutencao,
                      long kilometragem) {
        if(chassi == null || chassi.length() != 17)
            throw new IllegalArgumentException("O código de chassi deve conter 17 dígitos");

        else if(placa == null || placa.length() != 7)
            throw new IllegalArgumentException("A placa deve conter 7 dígitos");

        else if(modelo == null)
            throw new IllegalArgumentException("Modelo inválido");

        else if(fabricante == null)
            throw new IllegalArgumentException("Fabricante inválido");

        else if(ano < 1900)
            throw new IllegalArgumentException("Ano inválido");

        else if(dono == null)
            throw new  IllegalArgumentException("Dono inválido");

        else if(ultimaManutencao == null)
            throw new IllegalArgumentException("Data de última manutenção inválida");

        else if(kilometragem < 0)
            throw new IllegalArgumentException("Kilometragem não pode ser negativa");

        Caminhao caminhao = new Caminhao(chassi, placa, modelo, ano, fabricante, ultimaManutencao,
                dono, kilometragem);

        repositorioCaminhao.criar(caminhao);
        controladorCliente.adicionarAFrota(dono, caminhao);
    }

    public void remover(String chassi, String placa) throws IllegalArgumentException {
        if(chassi == null || placa == null)
            throw new IllegalArgumentException();

        Caminhao caminhao = new Caminhao(chassi, placa);

        repositorioCaminhao.deletar(caminhao);
    }

    public Caminhao buscarPorChassi(String chassi) {
        Caminhao c = new Caminhao(chassi);

        for(Caminhao caminhao : repositorioCaminhao.ler())
            if(caminhao.getChassi().equals(c.getChassi()))
                return caminhao;

        return null;
    }

    public ArrayList<Caminhao> buscarTodosCaminhoes() {
        return (ArrayList) repositorioCaminhao.ler();
    }

    public List<String> listarChassis() {
        List<String> chassis = new ArrayList<>();
        for(Caminhao c : repositorioCaminhao.ler())
            chassis.add(c.getChassi());

        return chassis;
    }

    public Cliente buscarDono(Caminhao caminhao) {
        for(Caminhao c : repositorioCaminhao.ler())
            if(c.equals(caminhao))
                return c.getDono();

        return null;
    }

}
