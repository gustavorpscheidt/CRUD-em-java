package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_cpf;
	private JTextField campo_nome;
	private JTextField campo_endereco;

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
	public InsertCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite as informações:");
		lblNewLabel.setBounds(0, 0, 144, 14);
		contentPane.add(lblNewLabel);
		
		campo_cpf = new JTextField();
		campo_cpf.setBounds(70, 25, 86, 20);
		contentPane.add(campo_cpf);
		campo_cpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(10, 28, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(204, 28, 39, 14);
		contentPane.add(lblNewLabel_2);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(246, 25, 86, 20);
		contentPane.add(campo_nome);
		campo_nome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endereco");
		lblNewLabel_3.setBounds(10, 53, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		campo_endereco = new JTextField();
		campo_endereco.setBounds(70, 50, 86, 20);
		contentPane.add(campo_endereco);
		campo_endereco.setColumns(10);
		
		JLabel Erro = new JLabel("");
		Erro.setBounds(44, 78, 46, 14);
		contentPane.add(Erro);
		
			LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (campo_cpf.getText().isEmpty() || campo_nome.getText().isEmpty() || campo_endereco.getText().isEmpty()) {
					lbnErro.setText("Preencha todos os campos!");
					return;
				}
				
				try {
				Connection conecta = Conexao.conectar();
				String sql = "insert into clientes (cpf,nome,endereco) values "
						+ "('" +campo_cpf.getText() +"','"+campo_nome.getText()+"','"+campo_endereco.getText()+"');";//TEM Q VALIDAR O CPF
				 Statement stmt = conecta.createStatement();
				 stmt.executeUpdate(sql);
				}catch(Exception ex) {
					lbnErro.setText("Erro:" + ex.getMessage());				
					}
				
				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);
			}
		});
		btnNewButton.setBounds(246, 56, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar",this);
		contentPane.add(butVoltar);
		
	

	}
}
