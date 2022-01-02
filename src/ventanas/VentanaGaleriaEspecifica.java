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
import java.awt.event.ActionEvent;
import BD.BD;
import clases.Actividad;

public class VentanaGaleriaEspecifica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel panel2;
    private JPanel panel2Derecha;
	private JPanel panel2Izquierda;
	
	static Logger logger = Logger.getLogger(VentanaGaleriaEspecifica.class.getName());

	public VentanaGaleriaEspecifica(Actividad actividad) throws IOException {
		
		setTitle("Galería de fotos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 690));
        setVisible(true);
		pack();
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		panel2 = new JPanel(new BorderLayout());
        panel2Izquierda = new JPanel(new GridLayout(6, 1));
        panel2Derecha = new JPanel(new GridLayout(3, 1));

        JPanel panelLabelNombre = new JPanel();
        JLabel labelNombre = new JLabel(actividad.getNombre());
        labelNombre.setFont(new Font("Serif", Font.PLAIN, 20));
        panelLabelNombre.add(labelNombre);

        JPanel panelLabelCodigo = new JPanel();
        
        JLabel labelCodigo = new JLabel(actividad.getCodigo());
        panelLabelCodigo.add(labelCodigo);

        JPanel panelLabelAforo = new JPanel();
        JLabel labelAforo = new JLabel(String.valueOf(actividad.getAforo()));
        panelLabelAforo.add(labelAforo);

        JPanel panelLabelInstructor = new JPanel();
        JLabel labelInstructor = new JLabel("Instructor: " + actividad.getInstructor());
        panelLabelInstructor.add(labelInstructor);

        JPanel panelLabelUbicacion = new JPanel();
        JLabel labelUbicacion = new JLabel(actividad.getUbicacion());
        panelLabelUbicacion.add(labelUbicacion);

        JPanel panelLabelCantidadMaterial = new JPanel();
        JLabel labelCantidadMaterial= new JLabel("Cantidad material : ");
        panelLabelCantidadMaterial.add(labelCantidadMaterial);

        panel2Izquierda.add(panelLabelNombre);
        panel2Izquierda.add(panelLabelCodigo);
        panel2Izquierda.add(panelLabelAforo);
        panel2Izquierda.add(panelLabelInstructor);
        panel2Izquierda.add(panelLabelUbicacion);
        panel2Izquierda.add(panelLabelCantidadMaterial);

        JPanel panelLabelDescripcion = new JPanel();
        //panelLabelDescripcion.setSize(30, 20);
        JLabel labelDescripcion = new JLabel("Descripción:" /*En náutica, el barco es un navío de gran tamaño para navegación costera y fluvial. Tiene construcción cóncava y fusiforme, de madera, metal, fibra de vidrio u otro material que, por su forma, es capaz de flotar en el agua y que se utiliza para navegar como medio de transporte.*/);
        panelLabelDescripcion.add(labelDescripcion);

        Border border2 = panelLabelDescripcion.getBorder();
        Border margin2 = new EmptyBorder(80, 0, 0, 0);
        panelLabelDescripcion.setBorder(new CompoundBorder(border2, margin2));

        BufferedImage bufferedImage = ImageIO.read(new File(actividad.getImagen() + ".jpg"));
        Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        JLabel labelImagen = new JLabel(new ImageIcon(image));

        Border border1 = labelImagen.getBorder();
        Border margin1 = new EmptyBorder(20, 300, 0, 0);
        labelImagen.setBorder(new CompoundBorder(border1, margin1));

        JPanel panelBotonAtras = new JPanel();
        JButton botonAtras = new JButton("Atrás"); //bd.getActividades
        botonAtras.setPreferredSize(new Dimension(200, 40));
        panelBotonAtras.add(botonAtras);

        Border border = panelBotonAtras.getBorder();
        Border margin = new EmptyBorder(120, 480, 10, 0);
        panelBotonAtras.setBorder(new CompoundBorder(border, margin));

        botonAtras.addActionListener(new ActionListener() {
				
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new VentanaGaleria();
                    dispose();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                	logger.log(Level.INFO, "");//METER LA INFO DEL ERROR
                }
            }
        });

        panel2Derecha.add(panelLabelDescripcion);
        panel2Derecha.add(labelImagen);
        panel2Derecha.add(panelBotonAtras);

        panel2.add(panel2Izquierda, BorderLayout.WEST);
        panel2.add(panel2Derecha, BorderLayout.EAST);

        //

        contentPane.setVisible(true);
        panel2.setVisible(true);
        contentPane.add(panel2);
    
	}
	
}
