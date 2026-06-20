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

public class DeleteCliente extends JFrame {

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCliente frame = new DeleteCliente();
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
	public DeleteCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Condiçâo:");
		lblNewLabel.setBounds(10, 10, 77, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton btn_nome = new JRadioButton("Nome");
		buttonGroup_2.add(btn_nome);
		btn_nome.setBounds(14, 34, 109, 23);
		contentPane.add(btn_nome);
		
		JRadioButton btn_endereco = new JRadioButton("Endereço");
		buttonGroup_2.add(btn_endereco);
		btn_endereco.setBounds(137, 34, 109, 23);
		contentPane.add(btn_endereco);
		
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
		
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar",this);
		contentPane.add(butVoltar);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);
		
		JRadioButton btn_cpf = new JRadioButton("cpf");
		buttonGroup_2.add(btn_cpf);
		btn_cpf.setBounds(265, 35, 109, 23);
		contentPane.add(btn_cpf);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campo_condicao.getText().isEmpty()) {
					lbnErro.setText("Erro: Campo condiçâo vazio");
					return;
				}if(!btn_nome.isSelected() && !btn_endereco.isSelected() && !btn_cpf.isSelected()) {
					lbnErro.setText("Erro: Selecione um campo para deletar");
					return;
					}if(!btn_conter.isSelected() && !btn_igual.isSelected()) {
						lbnErro.setText("Erro: Selecione uma condiçâo de deleção");
						return;
					}
				
				
				try {
					String sql = "";
					Connection conecta = Conexao.conectar();
					if (btn_igual.isSelected()) {
						if (btn_nome.isSelected()) {
							sql = "delete from clientes where nome ='" + campo_condicao.getText() + "';";
						}
						if(btn_endereco.isSelected()) {
							sql = "delete from clientes where endereco ='" + campo_condicao.getText() + "';";
						}
						if(btn_cpf.isSelected()) {
							sql = "delete from clientes where cpf ='" + campo_condicao.getText() + "';";
						}
					}else if(btn_conter.isSelected()) {
						if (btn_nome.isSelected()) {
							sql = "delete from clientes where nome like '%" + campo_condicao.getText() + "%';";
						}
						if(btn_endereco.isSelected()) {
							sql = "delete from clientes where endereco like'%" + campo_condicao.getText() + "%';";
						}
						if(btn_cpf.isSelected()) {
							sql = "delete from clientes where cpf like'%" + campo_condicao.getText() + "%';";
						}
						
					}else {
						return;//TEM QUE POR MENSAGEM DE ERRO.
					}

					Statement stmt = conecta.createStatement();
					 stmt.executeUpdate(sql);
				} catch (Exception ex) {
					lbnErro.setText("Erro: " + ex.getMessage());
				}

				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);

			
				
				
			}
		});
		btnNewButton.setBounds(10, 64, 113, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		

	}
}
