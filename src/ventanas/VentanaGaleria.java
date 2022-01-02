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
    private JPanel panel1;
    private JPanel panel1Arriba;
    private JPanel panel1Abajo;
    private JPanel panelFotoBoton;

    private String nombre = "NOMBRE ACTIVIDAD";
    private String instructor = "Instructor";

    private ArrayList<Actividad> listaActividades;

    static Logger logger = Logger.getLogger(VentanaGaleria.class.getName());

    private Actividad actividad;

    public VentanaGaleria() throws IOException {

    	addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	bd.ficheroLogger();
            }
        });
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

        int numFotos = listaActividades.size(); // calculará el número de fotos que haya en la bd

        panel1 = new JPanel(new BorderLayout());
        panel1Arriba = new JPanel(new GridLayout(numFotos / 2, 2));
        scroll = new JScrollPane(panel1Arriba);
        scroll.setPreferredSize(new Dimension(990, 600));
        panel1Abajo = new JPanel(new BorderLayout());

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
                        logger.log(Level.INFO, "");
                    }
                }
            });
        
            panelFotoBoton = new JPanel(new GridLayout(2, 1));

            Border border = panelFotoBoton.getBorder();
            Border margin = new EmptyBorder(25, 0, -145, 0);
            panelFotoBoton.setBorder(new CompoundBorder(border, margin));

            panelFotoBoton.add(labelImagen);
            panelFotoBoton.add(panelBotonActividad);

            panel1Arriba.add(panelFotoBoton);
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
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        panel1Abajo.add(panelBotonVolver);
        panel1.add(scroll, BorderLayout.NORTH);
        panel1.add(panel1Abajo, BorderLayout.SOUTH);
        contentPane.setVisible(true);
        panel1.setVisible(true);
        contentPane.add(panel1);
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