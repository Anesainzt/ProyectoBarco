package ventana;

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
import clases.Buceo;
import clases.Ski;
import clases.Surf;

public class VentanaGaleria extends JFrame{

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

    private JPanel panel2;
    private JPanel panel2Derecha;
    private JPanel panel2Izquierda;

    private String nombre = "NOMBRE ACTIVIDAD";
    private String instructor = "Instructor";

    private List<Surf> listaSurf;
    private List<Ski> listaSki;
    private List<Buceo> listaBuceo;
    private ArrayList<Actividad> listaActividades;

    static Logger logger = Logger.getLogger(VentanaGaleria.class.getName());

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
        
        // panel 1

        int numFotos = listaActividades.size(); // calculará el número de fotos que haya en la bd

        panel1 = new JPanel(new BorderLayout());
        panel1Arriba = new JPanel(new GridLayout(numFotos / 2, 2));
        scroll = new JScrollPane(panel1Arriba);
        scroll.setPreferredSize(new Dimension(990, 600));
        panel1Abajo = new JPanel(new BorderLayout());

        for (int i = 0; i < numFotos; i++) {
            BufferedImage bufferedImage = ImageIO.read(new File(listaActividades.get(i).getImagen() + ".jpg"));
            Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);

            JLabel labelImagen = new JLabel(new ImageIcon(image));

            JPanel panelBotonTitulo = new JPanel();
            JButton botonTitulo = new JButton(listaActividades.get(i).getNombre()); //bd.getActividades
            botonTitulo.setPreferredSize(new Dimension(200, 40));
            panelBotonTitulo.add(botonTitulo);

            panelFotoBoton = new JPanel(new GridLayout(2, 1));

            Border border = panelFotoBoton.getBorder();
            Border margin = new EmptyBorder(25, 0, -145, 0);
            panelFotoBoton.setBorder(new CompoundBorder(border, margin));

            panelFotoBoton.add(labelImagen);
            panelFotoBoton.add(panelBotonTitulo);

            panel1Arriba.add(panelFotoBoton);

            botonTitulo.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        panel1.setVisible(false);
                        panel2.setVisible(true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
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

        // panel 2

        panel2 = new JPanel(new BorderLayout());
        panel2Izquierda = new JPanel(new GridLayout(6, 1));
        panel2Derecha = new JPanel(new GridLayout(3, 1));

        JPanel panelLabelNombre = new JPanel();
        JLabel labelNombre = new JLabel(nombre);
        labelNombre.setFont(new Font("Serif", Font.PLAIN, 20));
        panelLabelNombre.add(labelNombre);

        JPanel panelLabelCodigo = new JPanel();
        JLabel labelCodigo = new JLabel("Código");
        panelLabelCodigo.add(labelCodigo);

        JPanel panelLabelAforo = new JPanel();
        JLabel labelAforo = new JLabel("Aforo");
        panelLabelAforo.add(labelAforo);

        JPanel panelLabelInstructor = new JPanel();
        JLabel labelInstructor = new JLabel("Instructor: " +instructor);
        panelLabelInstructor.add(labelInstructor);

        JPanel panelLabelUbicacion = new JPanel();
        JLabel labelUbicacion = new JLabel("Ubicación");
        panelLabelUbicacion.add(labelUbicacion);

        JPanel panelLabelCantidadMaterial = new JPanel();
        JLabel labelCantidadMaterial= new JLabel("Cantidad material");
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

        BufferedImage bufferedImage = ImageIO.read(new File("images/barco2.jpg"));
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
                    panel1.setVisible(true);
                    panel2.setVisible(false);
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
        panel1.setVisible(true);
        panel2.setVisible(false);

        contentPane.add(panel1);
        contentPane.add(panel2);
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
