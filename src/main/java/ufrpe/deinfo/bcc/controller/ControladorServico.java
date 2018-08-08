package ufrpe.deinfo.bcc.controller;

import ufrpe.deinfo.bcc.data.RepositorioServico;
import ufrpe.deinfo.bcc.model.Caminhao;
import ufrpe.deinfo.bcc.model.Cliente;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.model.Servico;

import java.time.LocalDate;

public class ControladorServico {
    private static ControladorServico instance;
    private RepositorioServico repositorioServico;
    private ControladorCliente controladorCliente;
    private ControladorFuncionario controladorFuncionario;

    private ControladorServico() {
        repositorioServico = RepositorioServico.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorFuncionario = ControladorFuncionario.getInstance();
    }

    public static ControladorServico getInstance() {
        if(instance == null)
            instance = new ControladorServico();

        return instance;
    }

    public void criar(LocalDate dataEntrada, LocalDate dataSaidaEstimada, long kilometragem,
                      String descricaoServico, Caminhao caminhao, Cliente cliente,
                      Funcionario mecanicoResponsavel) throws IllegalArgumentException {

        if(dataEntrada == null)
            throw new IllegalArgumentException("Data nula");
        else if(dataSaidaEstimada == null)
            throw new IllegalArgumentException("Data nula");
        else if(dataSaidaEstimada.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("A data de saída estimada não pode ser anterior a data de hoje");
        else if(kilometragem < 0)
            throw new IllegalArgumentException("Kilometragem não pode ser negativa");
        else if(descricaoServico == null)
            throw new IllegalArgumentException("Descrição nula");
        else if(descricaoServico.equals(""))
            throw new IllegalArgumentException("Descrição do serviço não pode ser vazia");
        else if(caminhao == null)
            throw new IllegalArgumentException("Caminhão nulo");
        else if(cliente == null)
            throw new IllegalArgumentException("Cliente nulo");
        else if(!controladorCliente.clienteExiste(cliente))
            throw new IllegalArgumentException("Cliente não existe");
        else if(mecanicoResponsavel == null)
            throw new IllegalArgumentException("Mecânico nulo");
        else if(!controladorFuncionario.funcionarioExiste(mecanicoResponsavel))
            throw new IllegalArgumentException("Mecânico não existe");


        Servico servico = new Servico(dataEntrada, dataSaidaEstimada, kilometragem, descricaoServico, caminhao,
                cliente, mecanicoResponsavel);
        repositorioServico.criar(servico);
    }
}
