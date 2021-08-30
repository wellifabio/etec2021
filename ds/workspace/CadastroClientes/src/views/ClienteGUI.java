package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlers.ClienteProcess;
import models.Cliente;

public class ClienteGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scroll;
	private JLabel cabecalho;
	private JTextField cpf, nome, telefone;
	private JButton add, del, salvar, cancelar;

	public ClienteGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("./assets/icone.png").getImage());
		setTitle("Cadastro de Clientes");
		setSize(800, 520);
		painel = new JPanel();
		setContentPane(painel);
		setLocationRelativeTo(null);
		setLayout(null);

		// Excreve o cabeçalho
		cabecalho = new JLabel(
				"CPF                                  Nome                                                             Telefone");
		cabecalho.setBounds(10, 10, 500, 20);
		painel.add(cabecalho);
		cpf = new JTextField();
		cpf.setBounds(10, 30, 120, 25);
		painel.add(cpf);
		nome = new JTextField();
		nome.setBounds(130, 30, 220, 25);
		painel.add(nome);
		telefone = new JTextField();
		telefone.setBounds(350, 30, 260, 25);
		painel.add(telefone);

		preencherLinhasTabela();

		add = new JButton("Add");
		add.setBounds(610, 30, 80, 24);
		painel.add(add);
		add.addActionListener(this);
		del = new JButton("Del");
		del.setBounds(690, 30, 80, 24);
		painel.add(del);
		del.addActionListener(this);

		salvar = new JButton("Salvar");
		salvar.setBounds(590, 450, 90, 24);
		painel.add(salvar);
		salvar.addActionListener(this);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(680, 450, 90, 24);
		painel.add(cancelar);
		cancelar.addActionListener(this);
	}

	private void preencherLinhasTabela() {
		// Definir o modelo da tabela
		dtm = new DefaultTableModel();
		// Cabeçalho da tabela
		dtm.addColumn("CPF");
		dtm.addColumn("Nome");
		dtm.addColumn("Telefone");
		// Laço que percorre a lista do Controle
		for (Cliente c : ClienteProcess.clientes) {
			dtm.addRow(c.toVetor());
		}
		table = new JTable(dtm); // Configura o modelo na tabela
		scroll = new JScrollPane(table); // Configura a tebela na barra de rolagem
		scroll.setBounds(10, 60, 763, 390); // Define a posição e tamanho na tela
		painel.add(scroll); // adiciona ao painel
	}

	private void create() {
		if (!cpf.getText().equals("") && !nome.getText().equals("") && !telefone.getText().equals("")) {
			// Acrescenta o cliente a lista do Controle
			ClienteProcess.clientes.add(new Cliente(cpf.getText(), nome.getText(), telefone.getText()));
			// Pega o útimo da lista
			Cliente c = ClienteProcess.clientes.get(ClienteProcess.clientes.size() - 1);
			// E coloca ele no defaultTableBodel
			dtm.addRow(c.toVetor());
		} else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos");
		}
	}

	private void delete() {
		if (table.getSelectedRow() >= 0) {
			ClienteProcess.clientes.remove(table.getSelectedRow());
			dtm.removeRow(table.getSelectedRow());
		} else {
			JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela");
		}
	}

	private void update() {
		ClienteProcess.clientes = new ArrayList<>();
		for (int i = 0; i < dtm.getRowCount(); i++) {
			ClienteProcess.clientes.add(new Cliente(dtm.getValueAt(i, 0).toString(), dtm.getValueAt(i, 1).toString(),
					dtm.getValueAt(i, 2).toString()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == add) {
			create();
		}
		if (event.getSource() == del) {
			delete();
		}
		if (event.getSource() == cancelar) {
			this.dispose();
		}
		if (event.getSource() == salvar) {
			// Atualizar a lista do controle com o defaultTableModel
			update();
			ClienteProcess.salvar();
			this.dispose();
		}

	}

	public static void main(String[] args) {
		ClienteProcess.abrir();
		new ClienteGUI().setVisible(true);
	}

}
