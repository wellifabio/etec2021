package viewers;

import controllers.ProcessaOrcamentos;
import models.Orcamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FormOrcamentos {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private JLabel cabecalho;
	private JTextField id,data,fornecedor,produto,preco;
	private JButton adicionar,sair;
	private JTextArea saida;
	
	public FormOrcamentos()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Registro de Orcamentos");
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		panel = new JPanel();
		frame.setContentPane(panel);
		frame.setLayout(null);
		
		cabecalho = new JLabel("| \t ID \t | \t DATA \t | \t FORNECEDOR \t | \t PRODUTO \t | \t PRECO \t |");
		cabecalho.setBounds(20, 20, 300, 20);
		
		id = new JTextField("");
		id.setBounds(20,40,40,20);
		
		data = new JTextField("");
		data.setBounds(70,40,80,20);
		
		fornecedor = new JTextField("");
		fornecedor.setBounds(160,40,80,20);
		
		produto = new JTextField("");
		produto.setBounds(250,40,80,20);
		
		preco = new JTextField("");
		preco.setBounds(340,40,40,20);
		
		adicionar = new JButton("Adicionar novo");
		adicionar.setBounds(20, 60, 300, 20);
		
		panel.add(cabecalho);
		panel.add(adicionar);
		panel.add(id);
		panel.add(data);
		panel.add(fornecedor);
		panel.add(produto);
		panel.add(preco);
		
		adicionar.addActionListener(new ButtonListener());
		
		saida = new JTextArea(20, 140);//5,20
		//saida.setBounds(20, 140, 500, 300);
		JScrollPane scrollPane = new JScrollPane(saida); 
		saida.setEditable(false);
		
		scrollPane.setBounds(20, 140, 500, 300);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//panel.add(saida);
		//scrollPane.add(saida);
		panel.add(scrollPane);
		
		
		
		
		frame.setVisible(true);
	}
	
	public String getDados()	
	{
		String s = "";
		for(int i = 0; i < ProcessaOrcamentos.orcamentos.size(); i++)
		{
			Orcamento o = ProcessaOrcamentos.orcamentos.get(i);
			s += this.format(Integer.toString(o.getId()));
			s += this.format(o.getData());
			s += this.format(o.getFornecedor());
			s += this.format(o.getProduto());
			s += this.format(Double.toString(o.getPreco()));
			s += "| \n";
		}
		
		return s;
	}
	
	public String format(String s)
	{
		return "| " + s + " ";
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = Integer.parseInt(id.getText());
			String d = data.getText();
			String f = fornecedor.getText();
			String p = produto.getText();
			Double pc = Double.parseDouble(preco.getText());
			Orcamento o = new Orcamento(i,d,f,p,pc);
			
			ProcessaOrcamentos.orcamentos.add(o);
			
			ProcessaOrcamentos.sort();
			saida.setText(getDados());
			frame.repaint();
		}
		
	}
	
	public static void main(String[] args)
	{
		new FormOrcamentos();
	}
	
}
