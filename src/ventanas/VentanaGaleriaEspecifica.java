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

public class VentanaGaleriaEspecifica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel panel2;
    private JPanel panel2Derecha;
	private JPanel panel2Izquierda;
	
	static Logger logger = Logger.getLogger(VentanaGaleriaEspecifica.class.getName());
	BD bd = new BD();

	public VentanaGaleriaEspecifica(Actividad actividad) throws IOException {
		
		addWindowListener( new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	bd.ficheroLogger();
            }
        });
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
        labelNombre.setFont(new Font("Arial", Font.PLAIN, 30));
        panelLabelNombre.add(labelNombre);

        JPanel panelLabelCodigo = new JPanel();
        JLabel labelCodigo = new JLabel("Código: " + actividad.getCodigo());
        labelCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLabelCodigo.add(labelCodigo);

        JPanel panelLabelAforo = new JPanel();
        JLabel labelAforo = new JLabel("Aforo: " + String.valueOf(actividad.getAforo()));
        labelAforo.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLabelAforo.add(labelAforo);

        JPanel panelLabelInstructor = new JPanel();
        JLabel labelInstructor = new JLabel("Instructor: " + actividad.getInstructor());
        labelInstructor.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLabelInstructor.add(labelInstructor);

        JPanel panelLabelUbicacion = new JPanel();
        JLabel labelUbicacion = new JLabel("Ubicación: " + actividad.getUbicacion());
        labelUbicacion.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLabelUbicacion.add(labelUbicacion);

        JPanel panelLabelCantidadMaterial = new JPanel();
        JLabel labelCantidadMaterial= new JLabel("Cantidad material: ");
        labelCantidadMaterial.setFont(new Font("Arial", Font.PLAIN, 20));
        panelLabelCantidadMaterial.add(labelCantidadMaterial);

        panel2Izquierda.add(panelLabelNombre);
        panel2Izquierda.add(panelLabelCodigo);
        panel2Izquierda.add(panelLabelAforo);
        panel2Izquierda.add(panelLabelInstructor);
        panel2Izquierda.add(panelLabelUbicacion);
        panel2Izquierda.add(panelLabelCantidadMaterial);

        JPanel panelTextDescripcion = new JPanel();
        JTextArea textDescripcion = new JTextArea(10, 45);
        textDescripcion.setEditable(false);
        textDescripcion.setText("Descripción: " + actividad.getDescripcion());
        panelTextDescripcion.add(textDescripcion);

        Border border2 = panelTextDescripcion.getBorder();
        Border margin2 = new EmptyBorder(80, 295, 0, 0);
        panelTextDescripcion.setBorder(new CompoundBorder(border2, margin2));

        BufferedImage bufferedImage = ImageIO.read(new File(actividad.getImagen() + ".jpg"));
        Image image = bufferedImage.getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        JLabel labelImagen = new JLabel(new ImageIcon(image));

        Border border1 = labelImagen.getBorder();
        Border margin1 = new EmptyBorder(20, 300, 0, 0);
        labelImagen.setBorder(new CompoundBorder(border1, margin1));

        JPanel panelBotonAtras = new JPanel();
        JButton botonAtras = new JButton("Atrás");
        botonAtras.setPreferredSize(new Dimension(200, 40));
        panelBotonAtras.add(botonAtras);

        Border border = panelBotonAtras.getBorder();
        Border margin = new EmptyBorder(30, 480, 10, 0);
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

        panel2Derecha.add(panelTextDescripcion);
        panel2Derecha.add(labelImagen);
        panel2Derecha.add(panelBotonAtras);

        panel2.add(panel2Izquierda, BorderLayout.WEST);
        panel2.add(panel2Derecha, BorderLayout.EAST);

        contentPane.setVisible(true);
        panel2.setVisible(true);
        contentPane.add(panel2);
	}
}