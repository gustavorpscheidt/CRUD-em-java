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

public class DeleteCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField Campo_condicao;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
	public DeleteCarro() {
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
		buttonGroup.add(btn_placa);
		btn_placa.setBounds(20, 34, 77, 23);
		contentPane.add(btn_placa);

		JRadioButton btn_veiculo = new JRadioButton("Estado Do veículo");
		buttonGroup.add(btn_veiculo);
		btn_veiculo.setBounds(99, 34, 178, 23);
		contentPane.add(btn_veiculo);

		Campo_condicao = new JTextField();
		Campo_condicao.setBounds(122, 7, 86, 20);
		contentPane.add(Campo_condicao);
		Campo_condicao.setColumns(10);

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
		JButton btn_confirmar = new JButton("Confirmar");
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);
		btn_confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btn_placa.isSelected() && !btn_veiculo.isSelected()) {
					lbnErro.setText("Erro: Selecione um campo para deletar");
					return;
				}
				if (!btn_conter.isSelected() && !btn_igual.isSelected()) {
					lbnErro.setText("Erro: Selecione uma condiçâo de deleção");
					return;
				}
				if (Campo_condicao.getText().isEmpty()) {
					lbnErro.setText("Erro: Campo condiçâo vazio");
					return;
				}
				try {
					String sql = "";
					Connection conecta = Conexao.conectar();
					if (btn_igual.isSelected()) {
						if (btn_placa.isSelected()) {
							sql = "delete from carros where placa_carro ='" + Campo_condicao.getText() + "';";
						}
						if(btn_veiculo.isSelected()) {
							sql = "delete from carros where estado ='" + Campo_condicao.getText() + "';";
						}
					}else if(btn_conter.isSelected()) {
						if (btn_placa.isSelected()) {
							sql = "delete from carros where placa_carro like '%" + Campo_condicao.getText() + "%';";
						}
						if(btn_veiculo.isSelected()) {
							sql = "delete from carros where estado like'%" + Campo_condicao.getText() + "%';";
						}
					}else {
						return;
					}

					Statement stmt = conecta.createStatement();
					 stmt.executeUpdate(sql);
					 
					 conecta.close();
					 stmt.close();
				} catch (Exception ex) {
					lbnErro.setText("Erro: " + ex.getMessage());
				}

				setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);

			}
		});
		btn_confirmar.setBounds(10, 64, 113, 23);
		contentPane.add(btn_confirmar);
		
		

	}
}
