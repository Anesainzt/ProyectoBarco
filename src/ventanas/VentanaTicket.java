package ventanas;

import javax.swing.*;

import BD.BD;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class VentanaTicket extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container cp;
    private JPanel panelPrincipal;
    private JLabel iconoI;
    BD bd = new BD();

    public VentanaTicket(){
    	

        cp = this.getContentPane();
        this.setTitle("Ticket");
        this.setSize(1000, 600);
        
        panelPrincipal = new JPanel(new GridLayout(2, 1));
        panelPrincipal.setSize(1000, 2000);
      //panelLabel
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new FlowLayout());
        
      //panelMedio
        JPanel panelMedio = new JPanel();
        panelMedio.setLayout(new GridLayout(1,2));
        
        JPanel panelIcono2 = new JPanel();
        panelIcono2.setLayout(new FlowLayout());
        
        iconoI = new JLabel(new ImageIcon("images/imprimir.png"));
        
        JPanel panelBoton2 = new JPanel();
        panelBoton2.setLayout(new FlowLayout());
        
        
       

        JLabel labelTexto = new JLabel("¡Viaje registrado correctamente!");
        JButton botonImprimir = new JButton("Imprimir");

        
        
        cp.add(panelPrincipal);
        
        panelPrincipal.add(panelLabel);
        panelPrincipal.add(panelMedio);
        
        panelLabel.add(labelTexto);
        
        panelMedio.add(panelIcono2);
        panelMedio.add(panelBoton2);
        
        panelIcono2.add(iconoI);
        
        panelBoton2.add(botonImprimir);
        
        this.pack();
        this.setTitle("Ticket");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(250,150);

    }
    public static void main(String[] args) {
		new VentanaTicket();
	}
    
}
