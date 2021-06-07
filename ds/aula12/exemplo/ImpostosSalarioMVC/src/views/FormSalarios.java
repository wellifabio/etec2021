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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.ProcessaSalarios;
import controllers.ProcessaTabelaINSS;
import controllers.ProcessaTabelaIRRF;
import models.INSS;
import models.IRRF;
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
	private JScrollPane scroll;

	FormSalarios() {
		// COnfigurações do Form principal
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cálculos de impostos sobre salário");
		setBounds(200, 100, 900, 550);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);

		// Barra de Menús
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuArquivo);
		barraMenu.add(menuSistema);
		iCreate = new JMenuItem("Cadastro");
		iUpdate = new JMenuItem("Alteração");
		iDelete = new JMenuItem("Exclusão");
		iSair = new JMenuItem("Sair do Sistema");
		menuArquivo.add(iCreate);
		menuArquivo.add(iUpdate);
		menuArquivo.add(iDelete);
		menuSistema.add(iSair);

		// Área de texto e Saída Principal
		textRead = new JTextArea(getSaida());
		textRead.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textRead.setEditable(false);
		scroll = new JScrollPane(textRead);
		scroll.setBounds(16, 15, 850, 455);
		panel.add(scroll);

		// Ações do Menú
		iCreate.addActionListener(this);
		iUpdate.addActionListener(this);
		iDelete.addActionListener(this);
		iSair.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == iCreate) {
			entrada = JOptionPane
					.showInputDialog("Digite matrícula, nome do funcionário e salário, separados por vírgula:");
			try {
				String[] vetorEntrada = entrada.split(",");
				salario = new Salario(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1],
						Double.parseDouble(vetorEntrada[2]));
				ProcessaSalarios.getSalarios().add(salario);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao cadastrar salário, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else if (e.getSource() == iUpdate) {
			entrada = JOptionPane.showInputDialog("Digite apenas a matrícula:");
			try {
				salario = new Salario(Integer.parseInt(entrada), null, 0);
				if (ProcessaSalarios.getSalarios().contains(salario)) {
					salario.setFuncionario(ProcessaSalarios.getSalarios()
							.get(ProcessaSalarios.getSalarios().indexOf(salario)).getFuncionario());
					entrada = JOptionPane
							.showInputDialog("Digite o novo salário para "
									+ ProcessaSalarios.getSalarios()
											.get(ProcessaSalarios.getSalarios().indexOf(salario)).getFuncionario()
									+ ":");
					salario.setSalario(Double.parseDouble(entrada));
					ProcessaSalarios.getSalarios().set(ProcessaSalarios.getSalarios().indexOf(salario), salario);
				} else {
					JOptionPane.showMessageDialog(this, "Matrícula não encontrada.");
				}
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao alterar salário, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else if (e.getSource() == iDelete) {
			entrada = JOptionPane.showInputDialog("Digite apenas a matrícula:");
			try {
				salario = new Salario(Integer.parseInt(entrada), null, 0);
				if (ProcessaSalarios.getSalarios().contains(salario)) {
					ProcessaSalarios.getSalarios().remove(ProcessaSalarios.getSalarios().indexOf(salario));
				} else {
					JOptionPane.showMessageDialog(this, "Matrícula não encontrada.");
				}
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(this, "Erro ao alterar salário, tente novamente: " + erro);
			}
			textRead.setText(getSaida());
		} else {
			dispose();
		}
	}

	public String getSaida() {

		double totalSalario = 0;
		double totalINSS = 0;
		double totalIRRF = 0;
		double totalSalLiq = 0;

		String dados = "\tINSS - Salário\t\tAlíquota\n";
		for (INSS i : ProcessaTabelaINSS.getTabINSS()) {
			dados += "\t" + i.toString() + "\n";
		}
		dados += "\tO teto do INSS = R$" + String.format("%.2f",
				(ProcessaTabelaINSS.getTabINSS().get(ProcessaTabelaINSS.getTabINSS().size() - 1).getContribuicao()
						* ProcessaTabelaINSS.getTabINSS().get(ProcessaTabelaINSS.getTabINSS().size() - 1)
								.getAliquota()))
				+ "\n";
		dados += "-------------------------------------------------------------------------------------------------------------------\n";
		dados += "\tIRRF - Salário\t\tAlíquota\tDeduzir\n";
		for (IRRF i : ProcessaTabelaIRRF.getIrrfs()) {
			dados += "\t" + i.toString() + "\n";
		}
		dados += "-------------------------------------------------------------------------------------------------------------------\n";
		dados += "\nMatrícula\tFuncionário\tSalário\tINSS'%'\tINSS'R$'\tSal. Base\tIRRF'%'\tIRRF'R$'\tA Deduzir\tSal. Líq.\n";
		Collections.sort(ProcessaSalarios.getSalarios(), new OrdenaPorMatricula());
		for (Salario s : ProcessaSalarios.getSalarios()) {
			dados += s.toString() + "\n";
			totalSalario += s.getSalario();
			totalINSS += s.getINSS();
			totalIRRF += s.getIRRF();
			totalSalLiq += s.getSalarioLiquido();
		}
		dados += "-------------------------------------------------------------------------------------------------------------------\n";
		dados += "Totais:\t\t" + String.format("%.2f", totalSalario) + "\t\t" + String.format("%.2f", totalINSS)
				+ "\t\t\t" + String.format("%.2f", totalIRRF) + "\t\t" + String.format("%.2f", totalSalLiq);
		return dados;
	}
}
