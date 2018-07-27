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
        Cliente clienteJuridico = new ClienteJuridico(endereco, email, telefone, cnpj, razaoSocial);
        repositorioCliente.criar(clienteJuridico);
    }
}
