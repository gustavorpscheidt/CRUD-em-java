package telas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BotaoVoltar extends JButton {
	public BotaoVoltar(String texto,JFrame f) {
		super(texto);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);

			}
		});
		setBounds(345, -4 , 89, 23);
		
		
	}

}
