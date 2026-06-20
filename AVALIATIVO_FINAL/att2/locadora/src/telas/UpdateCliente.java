package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexao.Conexao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField campo_condicao;
	private JRadioButton btn_nome;
	private JRadioButton btn_endereco;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton btn_conter;
	private JRadioButton btn_igual;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCliente frame = new UpdateCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}/*

	/**
	 * Create the frame.
	 */
	public UpdateCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Para que deseja alterar deseja alterar:");
		lblNewLabel.setBounds(10, 77, 233, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(253, 74, 69, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Condiçao:");
		lblNewLabel_1.setBounds(10, 11, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		campo_condicao = new JTextField();
		campo_condicao.setColumns(10);
		campo_condicao.setBounds(118, 8, 69, 20);
		contentPane.add(campo_condicao);
		
		btn_nome = new JRadioButton("Nome");
		buttonGroup.add(btn_nome);
		btn_nome.setBounds(6, 32, 109, 23);
		contentPane.add(btn_nome);
		
		btn_endereco = new JRadioButton("Endereço");
		buttonGroup.add(btn_endereco);
		btn_endereco.setBounds(117, 32, 109, 23);
		contentPane.add(btn_endereco);
		
		btn_conter = new JRadioButton("Alterar se conter o texto Digitado");
		buttonGroup_1.add(btn_conter);
		btn_conter.setBounds(6, 114, 267, 23);
		contentPane.add(btn_conter);
		
		btn_igual = new JRadioButton("Alterar se o texto for exatamente igual");
		buttonGroup_1.add(btn_igual);
		btn_igual.setBounds(6, 140, 267, 23);
		contentPane.add(btn_igual);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);
		
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);
		
		JButton btnNewButton = new JButton("confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btn_nome.isSelected() && !btn_endereco.isSelected()) {
					lbnErro.setText("Erro: Selecione um campo para alterar");
					return;
				}if(campo_condicao.getText().isEmpty() || textField.getText().isEmpty()) {
					lbnErro.setText("Erro: Preencha todos os campos");
					return;
				}if(!btn_igual.isSelected() && !btn_conter.isSelected()) {
					lbnErro.setText("Erro: Selecione uma condiçao");
					return;
				}

				try {
					String sql = "";
					Connection conecta = Conexao.conectar();
					if (btn_igual.isSelected()) {
						if (btn_nome.isSelected()) {
							sql = "update clientes set nome = "
									+ "'" + textField.getText() + "' where nome ='" + campo_condicao.getText() + "';";
						}
						if(btn_endereco.isSelected()) {
							sql = "update clientes set endereco = "
									+ "'" + textField.getText() + "' where endereco ='" + campo_condicao.getText() + "';";
						}
						
					}else if(btn_igual.isSelected()) {
						if (btn_nome.isSelected()) {
							sql = "update clientes set nome = "
									+ "'" + textField.getText() + "' where nome like'%" + campo_condicao.getText() + "%';";
						}
						if(btn_endereco.isSelected()) {
							sql = "update clientes set endereco = "
									+ "'" + textField.getText() + "' where endereco like'%" + campo_condicao.getText() + "%';";
						}
						
					}else {
						return;
					}

					Statement stmt = conecta.createStatement();
					 stmt.executeUpdate(sql);
					 conecta.close();
				} catch (Exception ex) {
					lbnErro.setText("Erro: " + ex.getMessage());
				}
			}
		});
		btnNewButton.setBounds(289, 104, 84, 20);
		contentPane.add(btnNewButton);
		

	}
}
