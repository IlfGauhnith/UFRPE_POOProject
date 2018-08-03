package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioCliente;
import ufrpe.deinfo.bcc.model.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorCliente {
    private RepositorioCliente repositorioCliente;
    private static ControladorCliente instance;

    private ControladorCliente() {
        repositorioCliente = RepositorioCliente.getInstance();
    }

    public static ControladorCliente getInstance() {
        if(instance == null)
            instance = new ControladorCliente();

        return instance;
    }

    public void criarClienteFisico(Endereco endereco, String email, String telefone, String nome,
                                   String cpf) {
        if(email == null)
            throw new IllegalArgumentException("Email inválido");
        else if(!telefone.matches("[0-9]+"))
            throw new IllegalArgumentException("Telefone inválido. Apenas números são permitidos.");
        else if(!cpf.matches("[0-9]+"))
            throw new IllegalArgumentException("CPF inválido. Apenas números são permitidos");
        else if(!nome.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("Nome inválido. Apenas letras são permitidas");
        else if(endereco == null)
            throw new IllegalArgumentException("Endereco inválido");

        Cliente clienteFisico = new ClienteFisico(endereco, email, telefone, nome, cpf);
        repositorioCliente.criar(clienteFisico);
    }

    public void criarClienteJuridico(Endereco endereco, String email, String telefone, String razaoSocial,
                                     String cnpj) throws IllegalArgumentException {
        if(email == null)
            throw new IllegalArgumentException("Email inválido");
        else if(!telefone.matches("[0-9]+"))
            throw new IllegalArgumentException("Telefone inválido. Apenas números são permitidos");
        else if(!cnpj.matches("[0-9]+"))
            throw new IllegalArgumentException("CNPJ inválido. Apenas números são permitidos");
        else if(razaoSocial == null)
            throw new IllegalArgumentException("Razão social inválida");
        else if(endereco == null)
            throw new IllegalArgumentException("Endereço inválido");

        Cliente clienteJuridico = new ClienteJuridico(endereco, email, telefone, cnpj, razaoSocial);
        repositorioCliente.criar(clienteJuridico);
    }

    public List<String> listarNomeClientes() {
        List<String> listaNomes = new ArrayList<>();

        for(Cliente c : repositorioCliente.ler()) {
            if(c instanceof ClienteFisico)
                listaNomes.add(((ClienteFisico) c).getNome());
            else if(c instanceof ClienteJuridico)
                listaNomes.add(((ClienteJuridico) c).getRazaoSocial());
        }

        return listaNomes;
    }

    public Cliente buscarPorNome(String nome) {
        for(Cliente c : repositorioCliente.ler()) {
            if(c instanceof ClienteFisico)
                if(((ClienteFisico) c).getNome().equals(nome))
                    return c;
            else if(c instanceof ClienteJuridico)
                if(((ClienteJuridico) c).getRazaoSocial().equals(nome))
                    return c;
        }
        return null;
    }

    public void adicionarAFrota(Cliente dono, Caminhao caminhao) {
        int donoIndex = repositorioCliente.ler().indexOf(dono);
        dono = repositorioCliente.ler().get(donoIndex);
        dono.adicionarCaminhaoAFrota(caminhao);
    }

    public String nomePorCaminhao(Caminhao caminhao) {
        if(caminhao.getDono() instanceof ClienteFisico)
            return ((ClienteFisico) caminhao.getDono()).getNome();
        else if(caminhao.getDono() instanceof ClienteJuridico)
            return ((ClienteJuridico) caminhao.getDono()).getRazaoSocial();

        return null;
    }

    public boolean clienteExiste(Cliente c) {
        return repositorioCliente.ler().contains(c);
    }
}
