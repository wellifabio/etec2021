package viewers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.ProcessaOrcamentos;
import models.Orcamento;

public class FormOrcamentos extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JLabel text;
	private JTextField inputId;
	private JTextField inputData;
	private JTextField inputFornecedor;
	private JTextField inputProduto;
	private JTextField inputPreco;
	private JTextArea output;
	private JButton button1;
	
	FormOrcamentos() {
		setTitle("Registro de Orçamentos");
		
		setSize(615, 615);
		p = new JPanel();
		setContentPane(p);
		setLayout(null);
		
		text = new JLabel("Digite os dados para fazer o orçamento:");
		text.setBounds(182, 20, 236, 30);
		
		inputId = new JTextField("Id:");
		inputId.setBounds(200, 50, 200, 20);
		inputData = new JTextField("Data:");
		inputData.setBounds(200, 70, 200, 20);
		inputFornecedor = new JTextField("Fornecedor:");
		inputFornecedor.setBounds(200, 90, 200, 20);
		inputProduto = new JTextField("Produto:");
		inputProduto.setBounds(200, 110, 200, 20);
		inputPreco = new JTextField("Preço:");
		inputPreco.setBounds(200, 130, 200, 20);
		
		output = new JTextArea();
		output.setBounds(50, 250, 500, 300);
		
		button1 =  new JButton("Adicionar");
		button1.setBounds(200, 170, 200, 30);
		button1.addActionListener(this);
		
		p.add(text);
		p.add(inputId);
		p.add(inputData);
		p.add(inputFornecedor);
		p.add(inputProduto);
		p.add(inputPreco);
		p.add(button1);
		p.add(output);
	}
	
	public String getDados() {
		String i = "Id\tData\tFornecedor\tProduto\tPreço\n\n";
		for (Orcamento o : ProcessaOrcamentos.orcamentos) {
			i += o.toString();
		}
		
		i += "\nMenor orçamento: " + String.format("%.2f", ProcessaOrcamentos.getMaisBarato());
		
		return i;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			Orcamento o = new Orcamento();
			
			o.setId(Integer.valueOf(inputId.getText()));
			o.setData(inputData.getText());
			o.setFornecedor(inputFornecedor.getText());
			o.setProduto(inputProduto.getText());
			o.setPreco(Double.valueOf(inputPreco.getText()));
			
			ProcessaOrcamentos.orcamentos.add(o);
			
			output.setText(getDados());
		}
	}
	
	public static void main(String[] args) {
		new FormOrcamentos().setVisible(true);
	}
}