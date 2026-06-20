package telas;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexao.Conexao;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertRelacionamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_placa;
	private JTextField campo_cpf;
	private JTextField campo_dataV;
	private JTextField campo_dataA;

	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { InsertCliente frame = new
		 * InsertCliente(); frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } }); }
		 */

	/**
	 * Create the frame.
	 */
	public InsertRelacionamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite as informações:");
		lblNewLabel.setBounds(0, 0, 144, 14);
		contentPane.add(lblNewLabel);

		campo_placa = new JTextField();
		campo_placa.setBounds(58, 25, 86, 20);
		contentPane.add(campo_placa);
		campo_placa.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(188, 28, 32, 14);
		contentPane.add(lblNewLabel_2);

		campo_cpf = new JTextField();
		campo_cpf.setBounds(230, 25, 86, 20);
		contentPane.add(campo_cpf);
		campo_cpf.setColumns(10);

		JLabel Erro = new JLabel("");
		Erro.setBounds(45, 110, 46, 14);
		contentPane.add(Erro);

		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (campo_placa.getText().isEmpty() || campo_cpf.getText().isEmpty() || campo_dataA.getText().isEmpty()
						|| campo_dataV.getText().isEmpty()) {
					lbnErro.setText("Erro: Preencha todos os campos");
					return;
				}
				try {
					try {
						SimpleDateFormat dataA = new SimpleDateFormat(campo_dataA.getText());
						SimpleDateFormat dataV = new SimpleDateFormat(campo_dataV.getText());
					} catch (Exception ex) {
						lbnErro.setText("Erro:" + ex.getMessage());
						return;
					}

					Connection conecta = Conexao.conectar();
					String sql = "insert into cliente_carros (placa_carro,cpf,data_locada,data_devolvido) values "
							+ "('" + campo_placa.getText() + "','" + campo_cpf.getText() + "','" + campo_dataA.getText()
							+ "','" + campo_dataV.getText() + "');";// trocar depois como
																	// está sendo feito
																	// isso.
					// TEM QUE VALIDAR A DATA.
					Statement stmt = conecta.createStatement();
					stmt.executeUpdate(sql);
				} catch (Exception ex) {
					lbnErro.setText("Erro:" + ex.getMessage());
				}

				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);

			}
		});
		btnNewButton.setBounds(44, 127, 89, 23);
		contentPane.add(btnNewButton);

		campo_dataV = new JTextField();
		campo_dataV.setText("YYYY-MM-D");
		campo_dataV.setColumns(10);
		campo_dataV.setBounds(279, 56, 86, 20);
		contentPane.add(campo_dataV);

		JLabel lblNewLabel_2_1 = new JLabel("Data devolvido");
		lblNewLabel_2_1.setBounds(191, 60, 89, 14);
		contentPane.add(lblNewLabel_2_1);

		campo_dataA = new JTextField();
		campo_dataA.setText("YYYY-MM-D");
		campo_dataA.setColumns(10);
		campo_dataA.setBounds(90, 55, 86, 20);
		contentPane.add(campo_dataA);

		JLabel lblNewLabel_1_1 = new JLabel("Data alugado");
		lblNewLabel_1_1.setBounds(10, 59, 77, 14);
		contentPane.add(lblNewLabel_1_1);

	}
}