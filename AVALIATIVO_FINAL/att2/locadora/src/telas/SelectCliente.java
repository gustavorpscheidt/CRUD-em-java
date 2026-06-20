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

public class SelectCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField Campo_condicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCliente frame = new SelectCliente();
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
	public SelectCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		BotaoVoltar butVoltar = new BotaoVoltar("Voltar", this);
		contentPane.add(butVoltar);
		int largura = 350;
		int altura = 100;

		JLabel lblNewLabel = new JLabel("Condição (relacionado ao CPF)");
		lblNewLabel.setBounds(10, 10, 210, 12);
		contentPane.add(lblNewLabel);

		Campo_condicao = new JTextField();
		Campo_condicao.setBounds(237, 7, 96, 18);
		contentPane.add(Campo_condicao);
		Campo_condicao.setColumns(10);

		table = new JTable();
		table.setBounds(0, 0, largura, altura);
		String[] colunas = { "CPF", "Nome", "Endereço" };
		DefaultTableModel model = new DefaultTableModel(colunas, 0);// começa com 0 linhas e com o cabealho
		table.setModel(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 48, largura, altura);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);

		LbnErro lbnErro = new LbnErro();
		contentPane.add(lbnErro);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="";
				model.setRowCount(0); // Limpa a tabela antes de adicionar novos dados
				
				if (Campo_condicao.getText().isEmpty()) {
					sql = "SELECT * FROM clientes";
				}
				else {
					String condicao = Campo_condicao.getText();
					 sql = "SELECT * FROM clientes WHERE cpf = '" + condicao + "';";
				}
				try {
					lbnErro.setText("");
						Connection conecta = Conexao.conectar();
						
						Statement stmt = conecta.createStatement();
						ResultSet rs = stmt.executeQuery(sql);

						while (rs.next()) {
							String cpf = rs.getString("cpf");
							String nome = rs.getString("nome");
							String endereco = rs.getString("endereco");
							Object[] row = { cpf, nome, endereco };

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
