package telas;
import telas.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {
	
	
	
	
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setTitle("Menu inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O que você deseja fazer?");
		lblNewLabel.setBounds(10, 0, 250, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Inserir dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMeio insert = new MenuMeio("insert");
				insert.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 25, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAlterarDados = new JButton("Alterar dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMeio insert = new MenuMeio("update");
				insert.setVisible(true);
			}
		});
		btnAlterarDados.setBounds(202, 25, 131, 23);
		contentPane.add(btnAlterarDados);
		
		JButton btnNewButton_1_1 = new JButton("Deletar dados");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMeio menu = new MenuMeio("delete");
				menu.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(20, 83, 133, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Visualizar dados");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMeio insert = new MenuMeio("select");
				insert.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(202, 83, 131, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

	}
}
