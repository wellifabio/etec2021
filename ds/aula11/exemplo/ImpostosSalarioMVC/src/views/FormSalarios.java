package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.ProcessaSalarios;
import controllers.ProcessaTabelaINSS;
import models.INSS;
import models.OrdenaPorMatricula;
import models.Salario;

public class FormSalarios extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Salario salario;
	private String entrada;
	private JPanel panel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuArquivo, menuSistema;
	private JMenuItem iCreate, iUpdate, iDelete, iSair;
	private JTextArea textRead;

	FormSalarios() {
		// COnfigura��es do Form principal
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("C�lculos de impostos sobre sal�rio");
		setBounds(200, 100, 700, 500);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);

		// Barra de Men�s
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuArquivo);
		barraMenu.add(menuSistema);
		iCreate = new JMenuItem("Cadastro");
		iUpdate = new JMenuItem("Altera��o");
		iDelete = new JMenuItem("Exclus�o");
		iSair = new JMenuItem("Sair do Sistema");
		menuArquivo.add(iCreate);
		menuArquivo.add(iUpdate);
		menuArquivo.add(iDelete);
		menuSistema.add(iSair);

		// �rea de texto e Sa�da Principal
		textRead = new JTextArea(getSaida());
		textRead.setBounds(16, 15, 650, 405);
		textRead.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textRead.setEditable(false);
		panel.add(textRead);

		// A��es do Men�
		iCreate.addActionListener(this);
		iUpdate.addActionListener(this);
		iDelete.addActionListener(this);
		iSair.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == iCreate) {
			entrada = JOptionPane
					.showInputDialog("Digite matr�cula, nome do funcion�rio e sal�rio, separados por v�rgula:");
			try {
				String[] vetorEntrada = entrada.split(",");
				salario = new Salario(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1],
						Double.parseDouble(vetorEntrada[2]));
				ProcessaSalarios.getSalarios().add(salario);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao cadastrar sal�rio, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else if (e.getSource() == iUpdate) {
			entrada = JOptionPane.showInputDialog("Digite apenas a matr�cula:");
			try {
				salario = new Salario(Integer.parseInt(entrada), null, 0);
				if (ProcessaSalarios.getSalarios().contains(salario)) {
					salario.setFuncionario(ProcessaSalarios.getSalarios()
							.get(ProcessaSalarios.getSalarios().indexOf(salario)).getFuncionario());
					entrada = JOptionPane
							.showInputDialog("Digite o novo sal�rio para "
									+ ProcessaSalarios.getSalarios()
											.get(ProcessaSalarios.getSalarios().indexOf(salario)).getFuncionario()
									+ ":");
					salario.setSalario(Double.parseDouble(entrada));
					ProcessaSalarios.getSalarios().set(ProcessaSalarios.getSalarios().indexOf(salario), salario);
				} else {
					JOptionPane.showMessageDialog(this, "Matr�cula n�o encontrada.");
				}
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao alterar sal�rio, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else if (e.getSource() == iDelete) {
			entrada = JOptionPane.showInputDialog("Digite apenas a matr�cula:");
			try {
				salario = new Salario(Integer.parseInt(entrada), null, 0);
				if (ProcessaSalarios.getSalarios().contains(salario)) {
					ProcessaSalarios.getSalarios().remove(ProcessaSalarios.getSalarios().indexOf(salario));
				} else {
					JOptionPane.showMessageDialog(this, "Matr�cula n�o encontrada.");
				}
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao alterar sal�rio, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else {
			dispose();
		}
	}

	public String getSaida() {
		String dados = "\tSal�rio\tAl�quota\n";
		for (INSS i : ProcessaTabelaINSS.getTabINSS()) {
			dados += "\t" + i.toString() + "\n";
		}
		dados += "\tMatr�cula\tFuncion�rio\tSal�rio\tINSS\tSal. Base\n";
		Collections.sort(ProcessaSalarios.getSalarios(),new OrdenaPorMatricula());
		for (Salario s : ProcessaSalarios.getSalarios()) {
			dados += "\t" + s.toString() + "\n";
		}
		return dados;
	}
}
