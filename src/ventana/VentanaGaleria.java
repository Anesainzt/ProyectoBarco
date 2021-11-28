package ventana;

import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BD.BD;
import clases.Buceo;
import clases.Ski;
import clases.Surf;

public class VentanaGaleria extends JFrame{

    private JPanel contentPane;
    private JScrollPane scroll;
    private JPanel panel1;

    private JPanel panel2;

    private String nombre = "SURF";
    private String instructor = "Manolo";

    private List<Surf> listaSurf;
    private List<Ski> listaSki;
    private List<Buceo> listaBuceo;

    static Logger logger = Logger.getLogger(VentanaGaleria.class.getName());

    public VentanaGaleria() throws IOException {

        BD bd = new BD();
        bd.connect();

        setTitle("Galería de fotos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));
        setVisible(true);
        pack();

        contentPane = new JPanel();
        setContentPane(contentPane);

        listaSurf = new ArrayList<Surf>(bd.getListaSurf());
        listaSki = new ArrayList<Ski>(bd.getListaSki());
        listaBuceo= new ArrayList<Buceo>(bd.getListaBuceo());

        for (Surf surf : listaSurf) {
            System.out.println(surf);
        }

        System.out.println(listaSurf);

        // panel 1

		int numFotos = 6; // calculará el número de fotos que haya en la bd
        
        panel1 = new JPanel(new GridLayout(numFotos, 2));
        panel1.setSize(1000, 2000);
        
        for (int i = 1; i <= numFotos; i+=2) {
            int j = i + 1;
            BufferedImage bufferedImage = ImageIO.read(new File("images/barco" +i+ ".jpg"));
            Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
            BufferedImage bufferedImage2 = ImageIO.read(new File("images/barco" +j+ ".jpg"));
            Image image2 = bufferedImage2.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		    //JLabel label = new JLabel(new ImageIcon(image));
            JButton boton = new JButton(new ImageIcon(image));
            JLabel label = new JLabel("hola"); //bd.getActividades
            JButton boton2 = new JButton(new ImageIcon(image2));
            JLabel label2 = new JLabel("hola"); //bd.getActividades
            //boton.setPreferredSize(new Dimension(200, 100));

            panel1.add(boton);
            panel1.add(boton2);
            panel1.add(label);
            panel1.add(label2);

            boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
                        scroll.setVisible(false);
                        panel2.setVisible(true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
				}
			});

            boton2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
                        scroll.setVisible(false);
                        panel2.setVisible(true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
				}
			});
        }

        scroll = new JScrollPane(panel1);
        scroll.setVisible(true);

        // panel 2

        panel2 = new JPanel(new GridLayout(4, 2));
        panel2.setSize(1000, 600);

        JLabel labelNombre = new JLabel(nombre);
        labelNombre.setFont(new Font("Serif", Font.PLAIN, 55));
        JLabel labelCodigo = new JLabel("Código");
        JLabel labelAforo = new JLabel("Aforo");
        JLabel labelInstructor = new JLabel("Instructor: " +instructor);
        JLabel labelUbicacion = new JLabel("Ubicación");
        JLabel labelDescripcion = new JLabel("Descripción");
        JLabel labelCantidadMaterial= new JLabel("Cantidad material");

        JButton botonAtras = new JButton("Atrás");

        BufferedImage bufferedImage = ImageIO.read(new File("images/barco2.jpg"));
        Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		JLabel labelImagen = new JLabel(new ImageIcon(image));

        panel2.add(labelNombre);
        panel2.add(labelCodigo);
        panel2.add(labelAforo);
        panel2.add(labelInstructor);
        panel2.add(labelUbicacion);
        panel2.add(labelDescripcion);
        panel2.add(labelCantidadMaterial);
        panel2.add(botonAtras);

        botonAtras.addActionListener(new ActionListener() {
				
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    scroll.setVisible(true);
                    panel2.setVisible(false);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                	//logger.log(Level.INFO, "");//METER LA INFO DEL ERROR
                }
            }
        });

        panel2.add(labelImagen);

        //

        contentPane.setVisible(true);
        panel1.setVisible(true);
        panel2.setVisible(false);

        contentPane.add(scroll);
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
