package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexao.Conexao;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteRelacionamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField campo_condicao;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { DeleteCliente frame = new
	 * DeleteCliente(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public DeleteRelacionamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Condiçâo:");
		lblNewLabel.setBounds(10, 10, 77, 14);
		contentPane.add(lblNewLabel);

		JRadioButton btn_placa = new JRadioButton("Placa");
		buttonGroup_2.add(btn_placa);
		btn_placa.setBounds(14, 34, 109, 23);
		contentPane.add(btn_placa);

		JRadioButton btn_cpf = new JRadioButton("CPF");
		buttonGroup_2.add(btn_cpf);
		btn_cpf.setBounds(137, 34, 109, 23);
		contentPane.add(btn_cpf);

		JRadioButton btn_dataA = new JRadioButton("Data alugado");
		buttonGroup_2.add(btn_dataA);
		btn_dataA.setBounds(259, 34, 121, 23);
		contentPane.add(btn_dataA);

		campo_condicao = new JTextField();
		campo_condicao.setBounds(122, 7, 86, 20);
		contentPane.add(campo_condicao);
		campo_condicao.setColumns(10);

		JRadioButton btn_conter = new JRadioButton("Deletar se conter o texto Digitado");
		buttonGroup_1.add(btn_conter);
		btn_conter.setBounds(10, 94, 267, 23);
		contentPane.add(btn_conter);

		JRadioButton btn_igual = new JRadioButton("Deletar se o texto for exatamente igual");
		buttonGroup_1.add(btn_igual);
		btn_igual.setBounds(10, 120, 267, 23);
		contentPane.add(btn_igual);

		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);

		JRadioButton btn_dataD = new JRadioButton("Data devolvido");
		buttonGroup_2.add(btn_dataD);
		btn_dataD.setBounds(259, 68, 121, 23);
		contentPane.add(btn_dataD);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btn_placa.isSelected() && !btn_cpf.isSelected() && !btn_dataA.isSelected()
						&& !btn_dataD.isSelected()) {
					lbnErro.setText("Erro: Selecione um campo para deletar");
					return;
				}
				if (campo_condicao.getText().isEmpty()) {
					lbnErro.setText("Erro: O campo de condiçâo nâo pode estar vazio");
					return;
				}
				if (!btn_conter.isSelected() && !btn_igual.isSelected()) {
					lbnErro.setText("Erro: Selecione um tipo de condiçâo");
					return;
				}
				
				
				try {
					String sql = "";
					Connection conecta = Conexao.conectar();
					if (btn_igual.isSelected()) {
						if (btn_placa.isSelected()) {
							sql = "delete from cliente_carros where placa_carro ='" + campo_condicao.getText() + "';";
						}
						if (btn_cpf.isSelected()) {
							sql = "delete from cliente_carros where cpf ='" + campo_condicao.getText() + "';";
						}
						if (btn_dataA.isSelected()) {
							sql = "delete from cliente_carros where data_locada ='" + campo_condicao.getText() + "';";
						}
						if (btn_dataD.isSelected()) {
							sql = "delete from cliente_carros where data_devolvido ='" + campo_condicao.getText()
									+ "';";
						}
					} else if (btn_conter.isSelected()) {
						if (btn_placa.isSelected()) {
							sql = "delete from cliente_carros where placa_carro like '%" + campo_condicao.getText()
									+ "%';";
						}
						if (btn_cpf.isSelected()) {
							sql = "delete from cliente_carros where cpf like'%" + campo_condicao.getText() + "%';";
						}
						if (btn_dataA.isSelected()) {
							sql = "delete from cliente_carros where data_locada like'%" + campo_condicao.getText()
									+ "%';";
						}
						if (btn_dataD.isSelected()) {
							sql = "delete from cliente_carros where data_devolvido like'%" + campo_condicao.getText()
									+ "%';";
						}
						conecta.close();
						;
					} else {
						return;// TEM QUE POR MENSAGEM DE ERRO.
					}

					Statement stmt = conecta.createStatement();
					stmt.executeUpdate(sql);
				} catch (Exception ex) {
					lbnErro.setText("Erro: " + ex.getMessage());
				}

				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);

				LbnErro lbnErro = new LbnErro();
				contentPane.add(lbnErro);

			}
		});
		btnNewButton.setBounds(10, 64, 113, 23);
		contentPane.add(btnNewButton);

	}
}
