package ventana;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaGaleriaActividades extends JFrame{

    private Container cp;
    private JPanel panelPrincipal;

    //prueba
    private String nombre = "Surf";
    private String instructor = "Manolo";

    public VentanaGaleriaActividades() throws IOException {

        cp = this.getContentPane();
        this.setTitle("Actividades");
        this.setSize(1000, 600);

        panelPrincipal = new JPanel(new GridLayout(7, 7));
        panelPrincipal.setSize(1000, 600);

        JLabel labelNombre = new JLabel(nombre);
        JLabel labelCodigo = new JLabel("Código");
        JLabel labelAforo = new JLabel("Aforo");
        JLabel labelInstructor = new JLabel("Instructor: " +instructor);
        JLabel labelUbicacion = new JLabel("Ubicación");
        JLabel labelDescripcion = new JLabel("Descripción");

        JButton botonAtras = new JButton("Atrás");

        BufferedImage bufferedImage = ImageIO.read(new File("images/barco2.jpg"));
        Image image = bufferedImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		JLabel labelImagen = new JLabel(new ImageIcon(image));

        panelPrincipal.add(labelNombre);
        panelPrincipal.add(labelCodigo);
        panelPrincipal.add(labelAforo);
        panelPrincipal.add(labelInstructor);
        panelPrincipal.add(labelUbicacion);
        panelPrincipal.add(labelDescripcion);
        panelPrincipal.add(botonAtras);
        panelPrincipal.add(labelImagen);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panelPrincipal);
        panelPrincipal.setVisible(true);
    }

	public static void main(String[] args) throws IOException {
		new VentanaGaleriaActividades();

	}
}
