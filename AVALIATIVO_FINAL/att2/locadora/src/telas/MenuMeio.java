package telas;

import java.awt.Color;
import java.awt.EventQueue;
import telas.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuMeio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuMeio(String texto) {// receber variavel para saber qual a operação e mudar o nome para MenuMeio
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Você deseja fazer " + texto + " na informação de quem?");
		lblNewLabel.setBounds(10, 0, 293, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (texto) {
				case "insert":
					setVisible(false);
					InsertCliente menu = new InsertCliente();
					menu.setVisible(true);

					break;
				case "delete":
					setVisible(false);
					DeleteCliente menu2 = new DeleteCliente();
					menu2.setVisible(true);

					break;

				case "update":
					setVisible(false);
					UpdateCliente menu3 = new UpdateCliente();
					menu3.setVisible(true);

					break;

				case "select":
					setVisible(false);
					SelectCliente menu4 = new SelectCliente();
					menu4.setVisible(true);

					break;

				}

			}
		});
		btnNewButton.setBounds(20, 25, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Carro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (texto) {
				case "insert":
					setVisible(false);
					InsertCarro menu3 = new InsertCarro();
					menu3.setVisible(true);

					break;
				case "delete":
					setVisible(false);
					DeleteCarro menu2 = new DeleteCarro();
					menu2.setVisible(true);

					break;

				case "update":
					setVisible(false);
					UpdateCarro menu4 = new UpdateCarro();
					menu4.setVisible(true);

					break;

				case "select":
					setVisible(false);
					SelectCarro menu5 = new SelectCarro();
					menu5.setVisible(true);

					break;

				}

			}
		});
		btnNewButton_1.setBounds(166, 25, 89, 23);
		contentPane.add(btnNewButton_1);

		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);

		JButton btnRelacionamentoCarrocliente = new JButton("Relacionamento Carro_cliente");
		btnRelacionamentoCarrocliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (texto) {
				case "insert":
					setVisible(false);
					InsertRelacionamento insert = new InsertRelacionamento();
					insert.setVisible(true);

					break;
				case "delete":
					setVisible(false);
					DeleteRelacionamento delete = new DeleteRelacionamento();
					delete.setVisible(true);

					break;

				case "update":
					
					setVisible(false);
					UpdateRelacionamento menuu = new UpdateRelacionamento();
					menuu.setVisible(true);

					break;

				case "select":
					setVisible(false);
					SelectRelacionamento menu5 = new SelectRelacionamento();
					menu5.setVisible(true);

					break;

				}

			}

		});
		btnRelacionamentoCarrocliente.setBounds(30, 59, 225, 23);
		contentPane.add(btnRelacionamentoCarrocliente);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

	}
}
