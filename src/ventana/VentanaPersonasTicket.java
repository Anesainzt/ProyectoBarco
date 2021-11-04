package ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BD.BD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaPersonasTicket extends JFrame{
	public VentanaPersonasTicket(){
		JPanel panelPrincipal = new JPanel();
		JPanel panelSecundario = new JPanel();
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		
		JLabel label1 = new JLabel("Cantidad de Personas");
		JLabel label2 = new JLabel("Adulto:");
		JLabel label3 = new JLabel("Niño:");
		JLabel label4 = new JLabel("(>=18)");
		JLabel label5 = new JLabel("(<18)");
		
		JTextField txt1 = new JTextField("", 10);
		JTextField txt2 = new JTextField("", 10);
		JButton boton1 = new JButton("Aceptar");
		
		boton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();
				bd.connect();
				//if() {
					try {
						new VentanaActividades();
						setVisible(false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				//}
				bd.disconnect();
			}
		});
		
		panelPrincipal.setLayout(new GridLayout(1,2));
		panelSecundario.setLayout(new GridLayout(4,1));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new FlowLayout());
		
		
		add(panelPrincipal);
		panelPrincipal.add(panelSecundario);
		
		panelSecundario.add(panel1);
		panelSecundario.add(panel2);
		panelSecundario.add(panel3);
		panelSecundario.add(panel4);
		
		panel1.add(label1);
		
		panel2.add(label2);
		panel2.add(txt1);
		panel2.add(label4);
		
		panel3.add(label3);
		panel3.add(txt2);
		panel3.add(label5);
		
		panel4.add(boton1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana Cantidad de Personas");
		pack();
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaPersonasTicket();
	}

}
