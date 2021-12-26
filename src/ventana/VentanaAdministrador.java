package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(400,320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelGeneral = new JPanel();

		panelGeneral.setLayout(new GridLayout(2,1)); 
		JPanel panelTitulo = new JPanel();

		panelTitulo.setLayout(new GridLayout(4,1)); 
		
		contentPane.add(panelGeneral);
		
		panelGeneral.add(panelTitulo);
		
		JPanel panel_4 = new JPanel();
		panelTitulo.add(panel_4);
		
		JTextPane txtpnMenuAdministrador = new JTextPane();
		panel_4.add(txtpnMenuAdministrador);
		txtpnMenuAdministrador.setText("MENU ADMINISTRADOR");
		txtpnMenuAdministrador.setBackground(getForeground());
		txtpnMenuAdministrador.setFont(new Font("Consolas", Font.BOLD, 18));
		txtpnMenuAdministrador.setForeground(Color.DARK_GRAY);
		
		JPanel panel = new JPanel();
		panelTitulo.add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panelTitulo.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panelTitulo.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panelGeneral.add(panel_3);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		
	}

}
