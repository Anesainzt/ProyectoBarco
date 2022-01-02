package ventanas;

import javax.swing.*;

import BD.BD;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class VentanaPago extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container cp;

    private JPanel panelPrincipal;

    private JPanel panelArriba;
    private JPanel panelArribaIzquierda;
    private JPanel panelArribaDerecha;

    private JPanel panelAbajo;
    
    static Logger logger = Logger.getLogger(VentanaPago.class.getName());
    BD bd = new BD();

    public VentanaPago() {
    	addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	bd.guardarLogger();
            }
          
        });

        cp = this.getContentPane();
        this.setTitle("Pago");
        this.setSize(850, 250);

        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setSize(500, 200);

        panelArriba = new JPanel(new GridLayout(1, 2));
        panelArribaIzquierda = new JPanel(new BorderLayout());

        JLabel labelTicket = new JLabel("Ticket");
        labelTicket.setFont(new Font("Serif", Font.PLAIN, 30));
        JLabel labelPrueba = new JLabel("Prueba");

        panelArribaDerecha = new JPanel(new GridLayout(3, 2));
        
        JLabel labelCuenta = new JLabel("Numero de cuenta:");
        JLabel labelNumeroCuenta = new JLabel();
        JLabel labelContraseña1 = new JLabel("Introduzca la contraseña:");
        
        JTextField textContraseña1 = new JPasswordField();
        JPanel panelTextoContraseña1 = new JPanel();
        textContraseña1.setPreferredSize(new Dimension(150, 25));
        panelTextoContraseña1.add(textContraseña1);
       
        JLabel labelContraseña2 = new JLabel("Vuelva a introducir la contraseña:");
    
        JPanel panelTextoContraseña2 = new JPanel(); 
        JTextField textContraseña2 = new JPasswordField();
        textContraseña2.setPreferredSize(new Dimension(150, 25));
        panelTextoContraseña2.add(textContraseña2);

        panelAbajo = new JPanel(new GridLayout(1, 2));

        JPanel panelBotonAceptar = new JPanel();
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setPreferredSize(new Dimension(150, 25));
        panelBotonAceptar.add(botonAceptar);
        
        JPanel panelBotonCancelar = new JPanel();

        panelPrincipal.add(panelArriba, BorderLayout.CENTER);
        panelPrincipal.add(panelAbajo, BorderLayout.SOUTH);

        panelArriba.add(panelArribaIzquierda);
        panelArriba.add(panelArribaDerecha);

        panelArribaIzquierda.add(labelTicket, BorderLayout.NORTH);
        panelArribaIzquierda.add(labelPrueba, BorderLayout.CENTER);
    
        panelArribaDerecha.add(labelCuenta);
        panelArribaDerecha.add(labelNumeroCuenta);
        panelArribaDerecha.add(labelContraseña1);
        panelArribaDerecha.add(panelTextoContraseña1);
        panelArribaDerecha.add(labelContraseña2);
        panelArribaDerecha.add(panelTextoContraseña2);

        panelAbajo.add(panelBotonCancelar);
        
        JButton botonAtras = new JButton("Atras");
        botonAtras.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new VentanaActividades();
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                	logger.log(Level.INFO, "No se ha podido abrir la VentanaPago");
                }
            }
        });
        panelBotonCancelar.add(botonAtras);
        
        JButton botonCerrarSesión = new JButton("Cerrar Sesion");
        botonCerrarSesión.addActionListener(new ActionListener() {
			
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            try {
	            	 dispose();
	            	 new VentanaInicio();
	        
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	            	logger.log(Level.INFO, "No se ha podido abrir la VentanaPago");
	            }
	        }
        });
        panelBotonCancelar.add(botonCerrarSesión);
        
        JButton botonSalir = new JButton("Salir");
        
        botonSalir.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	dispose();
            }
        });
        panelBotonCancelar.add(botonSalir);
        panelAbajo.add(panelBotonAceptar);

        botonAceptar.addActionListener(new ActionListener() {
				
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new VentanaTicket();
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                	logger.log(Level.INFO, "No se ha podido abrir la ventana");
                }
            }
        });

        cp.add(panelPrincipal);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}