package ventana;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VentanaGaleria extends JFrame{

	private Container cp;
    private JPanel panelPrincipal;
    private JScrollPane scroll;

    public VentanaGaleria() throws IOException {
        
        cp = this.getContentPane();
		this.setTitle("Galería de fotos");
        this.setSize(1000, 600);

		int numFotos = 4; // calculará el número de fotos que haya en la bd
        
        panelPrincipal = new JPanel(new GridLayout(numFotos/2, 2));
        panelPrincipal.setSize(1000, 2000);
        
        for (int i = 1; i <= numFotos; i++) {
            BufferedImage image = ImageIO.read(new File("images/barco" +i+ ".jpg"));
		    JLabel label = new JLabel(new ImageIcon(image));
            panelPrincipal.add(label);
        }

        scroll = new JScrollPane(panelPrincipal);
        scroll.setVisible(true);
        this.add(scroll);

        //this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
