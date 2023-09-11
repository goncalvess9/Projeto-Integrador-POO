package ADO1;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class CadastrodeImoveis {
    private List<Imovel> imoveis;

    public CadastrodeImoveis() {
        imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void cadastrarCasa() {
        Casa casa = new Casa();
        casa.setEndereco(JOptionPane.showInputDialog("Digite o endereço da casa:"));
        casa.setCidade(JOptionPane.showInputDialog("Digite a cidade:"));
        int tamanhoQuintal = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do quintal em metros quadrados:"));
        casa.setTamQuintal(tamanhoQuintal);
        double contaAgua = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta de água:"));
        casa.setContaAgua(contaAgua);
        adicionarImovel(casa);
    }

    public void cadastrarApartamento() {
        Apartamento apartamento = new Apartamento();
        apartamento.setEndereco(JOptionPane.showInputDialog("Digite o endereço do apartamento:"));
        apartamento.setCidade(JOptionPane.showInputDialog("Digite a cidade:"));
        double condominio = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do condomínio:"));
        apartamento.setCondominio(condominio);
        adicionarImovel(apartamento);
    }

    public void mostrarImoveis() {
        StringBuilder mensagem = new StringBuilder();
        for (Imovel imovel : imoveis) {
            mensagem.append(imovel.toString()).append("\n\n");
            if (imovel instanceof Casa) {
                Casa casa = (Casa) imovel;
                mensagem.append("Tipo: Casa\n");
                mensagem.append("Tamanho do Quintal: ").append(casa.getTamQuintal()).append(" metros quadrados\n");
                mensagem.append("Conta de Água: R$").append(casa.getContaAgua()).append("\n");
            } else if (imovel instanceof Apartamento) {
                Apartamento apartamento = (Apartamento) imovel;
                mensagem.append("Tipo: Apartamento\n");
                mensagem.append("Valor do Condomínio: R$").append(apartamento.getCondominio()).append("\n");
            }
            mensagem.append("........................\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Imóveis Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        CadastrodeImoveis cadastro = new CadastrodeImoveis();

        while (true) {
            String[] opcoes = {"Cadastrar Casa", "Cadastrar Apartamento", "Listar Imóveis", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Cadastro de Imóveis",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0:
                    cadastro.cadastrarCasa();
                    break;
                case 1:
                    cadastro.cadastrarApartamento();
                    break;
                case 2:
                    cadastro.mostrarImoveis();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
