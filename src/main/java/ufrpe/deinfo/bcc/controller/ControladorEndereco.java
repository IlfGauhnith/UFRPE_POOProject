package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioEndereco;
import ufrpe.deinfo.bcc.model.Endereco;

public class ControladorEndereco {
    private static ControladorEndereco instance;
    private RepositorioEndereco repositorioEndereco;

    private ControladorEndereco() {
        repositorioEndereco = RepositorioEndereco.getInstance();
    }

    public static ControladorEndereco getInstance() {
        if(instance == null)
            instance = new ControladorEndereco();

        return instance;
    }

    public void criarEndereco(String pais, String uf, String cidade, String bairro, String logradouro,
                              String numero, String complemento, String cep) throws IllegalArgumentException {
        if(pais == null || pais.length() == 0 || !pais.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("País inválido");

        else if(uf == null || uf.length() > 2 || !uf.matches("[a-zA-Z]+") || uf.length() == 0)
            throw new IllegalArgumentException("UF inválida");

        else if(cidade == null || cidade.length() == 0 || !cidade.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("Cidade inválida");

        else if(bairro == null || bairro.length() == 0 || !bairro.matches("^[a-zA-Z\\s]+$"))
            throw new IllegalArgumentException("Bairro inválido");

        else if(logradouro == null || logradouro.length() == 0)
            throw new IllegalArgumentException("Logradouro inválido");

        else if(numero == null || numero.length() == 0 || !numero.matches("[0-9]+"))
            throw new IllegalArgumentException("Número inválido");

        else if(complemento == null || complemento.length() == 0)
            throw new IllegalArgumentException("Complemento inválido");

        else if(cep == null || cep.length() != 8 || !cep.matches("[0-9]+"))
            throw new IllegalArgumentException("Cep inválido");

        Endereco endereco = new Endereco(pais, uf, cidade, bairro, logradouro, numero, complemento, cep);
        repositorioEndereco.criar(endereco);
    }

    public Endereco buscarPorCep(String cep) {
        Endereco endereco = new Endereco(cep);
        if(repositorioEndereco.ler().contains(endereco)) {
            int index = repositorioEndereco.ler().indexOf(endereco);
            endereco = repositorioEndereco.ler().get(index);
            return endereco;
        }

        return null;
    }
}
