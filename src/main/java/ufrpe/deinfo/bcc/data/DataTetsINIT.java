package ufrpe.deinfo.bcc.data;

import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.controller.ControladorCliente;
import ufrpe.deinfo.bcc.controller.ControladorEndereco;
import ufrpe.deinfo.bcc.controller.ControladorFuncionario;

import java.time.LocalDate;

public class DataTetsINIT {
    private ControladorCaminhao controladorCaminhao;
    private ControladorCliente controladorCliente;
    private ControladorEndereco controladorEndereco;
    private ControladorFuncionario controladorFuncionario;
    private static DataTetsINIT instance;

    String[] chassis = {"RM1NAB45QYZ2VRHCK", "JO5GMM0FTQRAOC1KA", "98D1PF9D4HBBFBH5I", "8HI5WK5NLPHZYG2ZR",
            "T2G1DUPN2SHDAKB6B", "W8R4A4YCBL8GRJFR9", "3197JNNDCTZMOP80A", "46K8P6IL9HP38GWWU", "T3IWOBIANFXZK4LXD",
            "GTA3J5ISBNC99E6IM"};
    String[] placas = {"BMKOKPA", "3K2868R", "KELIGVP", "4RSH62S", "NH0E98H", "UZJG7XI", "D39OL8X", "HER32ER",
            "A27FQ9T", "J6MGT5J"};
    String[] volvoModelos = {"FH-12", "FMX", "FH-16", "FM", "FH 520"};
    String[] scaniaModelos = {"R 500 XT", "G 360", "S 730", "XT", "P 230"};
    Integer[] anos = {2005, 2001, 2003, 2010, 2015, 2009, 2008, 2011, 2018, 2011};
    String[] fabricantes = {"Volvo", "Scania"};
    long[] kilometragem = {22394910, 57456103, 90242466, 94502016, 61503558, 34571254, 195355, 22705423, 38734560,
            82903442};
    String[] nomesClientes = {"Elminster Aumar", "Drizzt DoUrden"};
    String[] cpfClientes = {"12312312322", "12345612366"};
    String[] emailClientes = {"ElminsterAumar@ForgottenRealms.com", "Drizzt@ForgottenRealms.com"};
    String[] telefoneClientes = {"54561234", "123"};
    String[] ufsClientes = {"HR", "WV"};
    String[] cidadeClientes = {"Shadow Dale", "Menzoberranzan"};
    String[] bairroClientes = {"High Rock", "Shadow River"};
    String[] logradouroClientes = {"Goudenl Street", "Dtero Cliff"};
    String[] numeroClientes = {"231", "453"};
    String[] cepClientes = {"54921921", "53201202"};
    String[] complementosClientes = {"fawea", "ae1a"};

    private DataTetsINIT() {
        controladorCaminhao = ControladorCaminhao.getInstance();
        controladorEndereco = ControladorEndereco.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorFuncionario = ControladorFuncionario.getInstance();
    }

    public static DataTetsINIT getInstance() {
        if(instance == null)
            instance = new DataTetsINIT();

        return instance;
    }

    public void initData() {
        for(int i = 0 ; i < 2 ; i++) {
            controladorEndereco.criarEndereco("Faerun", ufsClientes[i], cidadeClientes[i], bairroClientes[i],
                    logradouroClientes[i], numeroClientes[i], complementosClientes[i], cepClientes[i]);

            controladorCliente.criarClienteFisico(controladorEndereco.buscarPorCep(cepClientes[i]), emailClientes[i],
                    telefoneClientes[i], nomesClientes[i], cpfClientes[i]);
        }

        for(int i = 0 ; i < 10 ; i++) {
            if(i <= 4)
                controladorCaminhao.criar(chassis[i], placas[i], volvoModelos[i], fabricantes[0], anos[i],
                        controladorCliente.buscarPorNome(nomesClientes[0]), kilometragem[i]);
            else if(i >= 5)
                controladorCaminhao.criar(chassis[i], placas[i], scaniaModelos[i-5], fabricantes[1], anos[i],
                        controladorCliente.buscarPorNome(nomesClientes[1]), kilometragem[i]);
        }

        controladorFuncionario.criar("Mattle", "awq", "Mecanico Assistente", "Tempus", "Hammer");
        controladorFuncionario.criar("Piccus", "1awfa", "Mecanico Chefe", "cook", "apple");
    }
}
