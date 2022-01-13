package ventanas;

import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import BD.BD;
import clases.Actividad;

public class VentanaGaleria extends JFrame {

    /**
     * 
     */

    public BD bd = new BD();
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JScrollPane scroll;
    private JPanel panel;
    private JPanel panelArriba;
    private JPanel panelAbajo;
    private JPanel panelFotoBoton;
    private JPanel panelFotoBoton2;

    private String nombre = "NOMBRE ACTIVIDAD";
    private String instructor = "Instructor";

    private ArrayList<Actividad> listaActividades;

    private Actividad actividad;

    public VentanaGaleria() throws IOException {

        bd.connect();

        setTitle("Galería de fotos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 690));
        setVisible(true);
        pack();

        contentPane = new JPanel();
        setContentPane(contentPane);

        listaActividades = new ArrayList<Actividad>();
        listaActividades = bd.getActividades();
       
        double numFotos = listaActividades.size();
        panel = new JPanel(new BorderLayout());
        
        double layoutY = Math.ceil(numFotos / 2);
        panelArriba = new JPanel(new GridLayout((int)layoutY, 2));
        
        scroll = new JScrollPane(panelArriba);
        scroll.setPreferredSize(new Dimension(990, 600));
        panelAbajo = new JPanel(new BorderLayout());

        for (int i = 0; i < numFotos; i++) {
            Actividad actividad = listaActividades.get(i);
            
            BufferedImage bufferedImage = ImageIO.read(new File(actividad.getImagen() + ".jpg"));
            Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);

            JLabel labelImagen = new JLabel(new ImageIcon(image));

            JPanel panelBotonActividad = new JPanel();
            JButton botonActividad = new JButton(actividad.getNombre() + " - " + actividad.getUbicacion()); //bd.getActividades
            botonActividad.setPreferredSize(new Dimension(200, 40));
            panelBotonActividad.add(botonActividad);

            botonActividad.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    try {
                        new VentanaGaleriaEspecifica(actividad);
                        dispose();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                    	bd.ficheroLogger();
                        bd.logger.log(Level.INFO, "No se puede abrir la ventana");
                        bd.closeLogger();
                    }
                }
            });

            panelFotoBoton = new JPanel(new GridLayout(2, 1));

            Border border = panelFotoBoton.getBorder();
            Border margin = new EmptyBorder(25, 0, -145, 0);
            panelFotoBoton.setBorder(new CompoundBorder(border, margin));

            panelFotoBoton.add(labelImagen);
            panelFotoBoton.add(panelBotonActividad);

            panelArriba.add(panelFotoBoton);

        }

        JPanel panelBotonVolver = new JPanel();
        JButton botonVolver = new JButton("Volver");
        botonVolver.setPreferredSize(new Dimension(200, 30));
        panelBotonVolver.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaViaje(bd.getuActual());
                    dispose();
                } catch (Exception e1) {
                	bd.ficheroLogger();
                    bd.logger.log(Level.INFO, "No se puede abrir la ventana");
                    bd.closeLogger();
                }
            }
        });

        panelAbajo.add(panelBotonVolver);
        panel.add(scroll, BorderLayout.NORTH);
        panel.add(panelAbajo, BorderLayout.SOUTH);
        contentPane.setVisible(true);
        panel.setVisible(true);
        contentPane.add(panel);
    }

    public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
		 public void run() {
		  try {
		   VentanaGaleria frame = new VentanaGaleria();
		   frame.setVisible(true);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
		});
	}
}