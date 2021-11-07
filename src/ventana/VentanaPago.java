package ventana;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPago extends JFrame{

    private Container cp;

    private JPanel panelPrincipal;

    private JPanel panelArriba;
    private JPanel panelArribaIzquierda;
    private JPanel panelArribaDerecha;

    private JPanel panelAbajo;

    public VentanaPago() {

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
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setPreferredSize(new Dimension(150, 25));
        panelBotonCancelar.add(botonCancelar);

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
        panelAbajo.add(panelBotonAceptar);

        botonAceptar.addActionListener(new ActionListener() {
				
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new VentanaTicket();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        cp.add(panelPrincipal);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.pack();
    }

    public static void main(String[] args) throws IOException {
		new VentanaPago();
	}
}