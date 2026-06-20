package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class SelectRelacionamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRelacionamento frame = new SelectRelacionamento();
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
	public SelectRelacionamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int largura = 350;
		int altura = 100;

		table = new JTable();
		table.setBounds(0, 0, largura, altura);
		String[] colunas = { "cpf", "placa_carro", "data_locada", "data_devolvida" };
		DefaultTableModel model = new DefaultTableModel(colunas, 0);// começa com 0 linhas e com o cabealho
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 48, largura, altura);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);

		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

		
		
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 model.setRowCount(0); // Limpa as linhas existentes na tabela
				try {
					lbnErro.setText("");
			Connection conecta = Conexao.conectar();
			String sql = "SELECT * FROM cliente_carros";
			Statement stmt = conecta.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String placa = rs.getString("placa_carro");
				String dataA = rs.getString("data_locada");
				String DataD = rs.getString("data_devolvido");
				Object[] row = { cpf, placa, dataA, DataD };

				model.addRow(row);
			}
			rs.close();
			stmt.close();
			conecta.close();
		} catch (SQLException ex) {
			lbnErro.setText("Erro: " + ex.getMessage());
		}
				
		if(lbnErro.getText().isEmpty() && model.getRowCount()==0) {
			lbnErro.setText("Erro: não existem dados correspondentes");	
		}

			}
		});
		btnNewButton.setBounds(29, 183, 114, 20);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		
		

	}
}
