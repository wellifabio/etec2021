/* Grupo:
	Jean C. Bueno
	Sarah Moreira Messias
	Nicolas Juliani Ferreira
	Nicholas Lopes de Almeida
	Matheus Lopes dos Santos
*/

package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ProcessaOrcamentos;
import models.Orcamento;

public class FormsOrcamento extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JPanel panel;
    private final JLabel lblId, lblData, lblFornecedor, lblProduto, lblPreco;
    private final JTextField id, data, fornecedor, produto, preco;
    private final JButton buttonAdi, buttonSair;
    private final JTextArea saida;

    FormsOrcamento() {
        //Cabeçalho
        setTitle("Registro de Orçamentos");
	setSize(700, 800);
	panel = new JPanel();
	setContentPane(panel);
	setLayout(null);
                
 
	lblId = new JLabel("Id: ");
	lblId.setBounds(40, 30, 200, 30);
	lblData = new JLabel("Data: ");
	lblData.setBounds(160, 30, 100, 30);
	lblFornecedor = new JLabel("Fornecedor: ");
	lblFornecedor.setBounds(310, 30, 100, 30);
	lblProduto = new JLabel("Produto: ");
	lblProduto.setBounds(40, 85, 200, 30);
	lblPreco = new JLabel("Preço: ");
	lblPreco.setBounds(265, 85, 100, 30);
        
        // Campos de Entrada
	id = new JTextField();
	id.setBounds(60, 32, 80, 25);
	data = new JTextField();
	data.setBounds(195, 32, 100, 25);
	fornecedor = new JTextField();
	fornecedor.setBounds(385, 32, 150, 25);
	produto = new JTextField();
	produto.setBounds(95, 87, 150, 25);
	preco = new JTextField();
	preco.setBounds(310, 87, 150, 25);
                
        // Botões e Campos de Saída
	buttonAdi = new JButton("Adicionar");
	buttonAdi.setBounds(100, 140, 150, 30);
	buttonAdi.addActionListener(this);
	buttonSair = new JButton("Sair");
	buttonSair.setBounds(300, 140, 150, 30);
	buttonSair.addActionListener(this);

	saida = new JTextArea(getDados());
	saida.setBounds(40, 195, 500, 300);

	// Adicionando os dados através de vetores
	JLabel[] vet1 = {lblId, lblData, lblFornecedor, lblProduto, lblPreco};
	JTextField[] vet2 = {id, data, fornecedor, produto, preco};

	for (JLabel l : vet1) {
            panel.add(l);
	}

	for (JTextField f : vet2) {
            panel.add(f);
	}

	panel.add(saida);
	panel.add(buttonAdi);
	panel.add(buttonSair);
	}

	private String getDados() {
            String retorno = "Id" + "\t" + "Data" + "\t" + "Fornecedor" + "\t" + "Produto" + "\t" + "Preço" + "\n" + "\n";
            retorno = ProcessaOrcamentos.orcamentos.stream().map((orc) -> orc.toString()).reduce(retorno, String::concat);
            retorno += "\n" + "Informações do menor orçamento:" + "\n" +"\n" + ProcessaOrcamentos.getPrecosFinais();
            return retorno;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonAdi) {
		Boolean confirm = true;
		// Confirmando se o ID digitado já não existe
		for (Orcamento orc : ProcessaOrcamentos.orcamentos) {
                    if (orc.getId() == Integer.valueOf(id.getText())) {
			confirm = false;
                    }
		}

		// Se o ID não existe, os dados digitados serão processados
		if (confirm) {
                    Orcamento orc = new Orcamento();
                    orc.setId(Integer.valueOf(id.getText()));
                    orc.setData(data.getText());
                    orc.setFornecedor(fornecedor.getText());
                    orc.setProduto(produto.getText());
                    orc.setPreco(Integer.valueOf(preco.getText()));
                    ProcessaOrcamentos.orcamentos.add(orc);
                    saida.setText(getDados());
                // Se não, a seguinte mensagem de erro será mostrada:
		} else {
                    saida.setText(getDados() + "\n" + "ERRO: O número de ID já existe!");
		}

            }

            if (e.getSource() == buttonSair) {
		System.exit(0);
            }

	}
        
        //Adicionando algumas informações padrões no Forms
	public static void main(String[] args) {
            ProcessaOrcamentos.orcamentos.add(new Orcamento(1, "24/06/2021", "Loja 1", "Um retângulo de vidro", 330.00));
            ProcessaOrcamentos.orcamentos.add(new Orcamento(2, "20/10/2021", "Loja 2", "Um retângulo de madeira", 180.00));
            ProcessaOrcamentos.orcamentos.add(new Orcamento(3, "01/08/2021", "Loja 3", "Um retângulo de metal", 280.00));
            ProcessaOrcamentos.orcamentos.add(new Orcamento(4, "15/08/2021","Loja 4", "Um retângulo de mármore", 530.00));
     
            new FormsOrcamento().setVisible(true);
	}

}
