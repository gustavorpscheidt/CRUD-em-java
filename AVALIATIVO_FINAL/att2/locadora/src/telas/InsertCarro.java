package telas;

import java.awt.EventQueue;

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
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_placa;
	private JTextField campo_estado;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCliente frame = new InsertCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public InsertCarro() {
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
		campo_placa.setBounds(70, 25, 86, 20);
		contentPane.add(campo_placa);
		campo_placa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setBounds(10, 28, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado do Veículo");// Se pá eu faço com que tenha Radio Button pra que escolha o estado.
		lblNewLabel_2.setBounds(188, 28, 114, 14);
		contentPane.add(lblNewLabel_2);
		
		campo_estado = new JTextField();
		campo_estado.setBounds(301, 25, 86, 20);
		contentPane.add(campo_estado);
		campo_estado.setColumns(10);
		
		JLabel Erro = new JLabel("");
		Erro.setBounds(44, 78, 46, 14);
		contentPane.add(Erro);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (campo_placa.getText().isEmpty() || campo_estado.getText().isEmpty()) {
					lbnErro.setText("Preencha todos os campos!");
					return;
				}
				try {
				Connection conecta = Conexao.conectar();
				String sql = "insert into carros (placa_carro,estado) values "
						+ "('" +campo_placa.getText() +"','"+campo_estado.getText()+"');";//tem que validar a placa
				 Statement stmt = conecta.createStatement();
				 stmt.executeUpdate(sql);
				}catch(Exception ex) {
					lbnErro.setText("Erro:"+ ex.getMessage());				
					}
				
				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);
			}
		});
		btnNewButton.setBounds(70, 69, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar",this);
		contentPane.add(butVoltar);
		
		

	}
}
