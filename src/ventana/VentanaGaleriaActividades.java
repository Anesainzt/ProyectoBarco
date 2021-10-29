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

    public VentanaGaleriaActividades(){

        cp = this.getContentPane();
        panelPrincipal = new JPanel(new GridLayout(2, 2));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        

    }

    public static void main(String[] args) {
		new VentanaGaleriaActividades();

	}


}
