package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioCliente;
import ufrpe.deinfo.bcc.model.Cliente;
import ufrpe.deinfo.bcc.model.ClienteFisico;
import ufrpe.deinfo.bcc.model.ClienteJuridico;
import ufrpe.deinfo.bcc.model.Endereco;

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
                                   String cpf) throws IllegalArgumentException {
        if(endereco == null || email == null || telefone == null || nome == null || cpf == null)
            throw new IllegalArgumentException();
        if(!telefone.matches("[0-9]+"))
            throw new IllegalArgumentException();
        if(!cpf.matches("[0-9]+"))
            throw new IllegalArgumentException();
        if(!nome.matches("[a-z]+, [A-Z]+"))
            throw new IllegalArgumentException();

        Cliente clienteFisico = new ClienteFisico(endereco, email, telefone, nome, cpf);
        repositorioCliente.criar(clienteFisico);
    }

    public void criarClienteJuridico(Endereco endereco, String email, String telefone, String razaoSocial,
                                     String cnpj) throws IllegalArgumentException {
        if(endereco == null || email == null || telefone == null || razaoSocial == null || cnpj == null)
            throw new IllegalArgumentException();
        if(!telefone.matches("[0-9]+"))
            throw new IllegalArgumentException();
        if(!cnpj.matches("[0-9]+"))
            throw new IllegalArgumentException();

        Cliente clienteJuridico = new ClienteJuridico(endereco, email, telefone, cnpj, razaoSocial);
        repositorioCliente.criar(clienteJuridico);
    }
}
