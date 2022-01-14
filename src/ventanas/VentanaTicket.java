package ventanas;

import javax.swing.*;

import BD.BD;
import clases.Actividad;
import clases.Usuario;
import clases.Viaje;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaTicket extends JFrame {

  private static final long serialVersionUID = 1L;
  private Container cp;
  private JPanel panelPrincipal;
  private JLabel iconoI;
  private int precioTotal = 0;

  BD bd = new BD();

  public VentanaTicket(Usuario uActual, Viaje viajeIda, Viaje viajeVuelta, int numeroPersonas,
      List<Actividad> listaActividades) {
  
    if (viajeVuelta != null) {
      precioTotal = (viajeIda.getPrecio() + viajeVuelta.getPrecio()) * numeroPersonas;
    } else {
      precioTotal = viajeIda.getPrecio() * numeroPersonas;
    }
    
    for (Actividad actividad : listaActividades) {
      precioTotal += (actividad.getPrecio() * numeroPersonas);
    }

    cp = this.getContentPane();
    this.setTitle("Ticket");
    this.setSize(1000, 600);

    panelPrincipal = new JPanel(new GridLayout(2, 1));
    panelPrincipal.setSize(1000, 2000);
    // panelLabel
    JPanel panelLabel = new JPanel();
    panelLabel.setLayout(new FlowLayout());

    // panelMedio
    JPanel panelMedio = new JPanel();
    panelMedio.setLayout(new GridLayout(1, 2));

    JPanel panelIcono2 = new JPanel();
    panelIcono2.setLayout(new FlowLayout());

    iconoI = new JLabel(new ImageIcon("images/imprimir.png"));

    JPanel panelBoton2 = new JPanel();
    panelBoton2.setLayout(new FlowLayout());

    JLabel labelTexto = new JLabel("¡Viaje registrado correctamente!");
    JButton botonImprimir = new JButton("Imprimir");

    botonImprimir.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        try {
          
          File file = new File("ticket.csv");
          FileWriter writer = new FileWriter(file);
          BufferedWriter buff = new BufferedWriter(writer);

          System.out.println(uActual.getNombre());
          buff.write("Reserva a nombre de: " + uActual.getNombre() + " " + uActual.getApellido());
          buff.newLine();
          buff.write("Num. personas: " + numeroPersonas);
          buff.newLine();
          buff.write("Billete ida: " + viajeIda.getOrigen() + "/" + viajeIda.getDestino());
          buff.newLine();
          buff.write("Total ida: " + String.valueOf(viajeIda.getPrecio()) + "€");
          buff.newLine();

          try {
            buff.write("Billete vuelta: " + viajeVuelta.getOrigen() + "/" + viajeVuelta.getDestino());
            buff.newLine();
            buff.write("Total vuelta: " + String.valueOf(viajeVuelta.getPrecio()) + "€");
            buff.newLine();
          } catch (Exception e) {
        	  
          }

          buff.write("Actividades: ");
          buff.newLine();

          for (Actividad actividad : listaActividades) {
            buff.write(String.valueOf(actividad.getNombre()) + " - " + actividad.getPrecio() + "€");
            buff.newLine();
          }

          buff.newLine();
          buff.write("Precio total: ");
          buff.newLine();
          buff.write(String.valueOf(precioTotal) + "€");
          buff.newLine();
          
          buff.flush();
          buff.close();
          writer.close();

          bd.ficheroLogger();
  		  bd.logger.log(Level.INFO, "Ticket impreso con éxito.");
  		  bd.closeLogger();
  		
          dispose();
          new VentanaViaje(uActual);
        } catch (Exception e) {
        	bd.ficheroLogger();
    		bd.logger.log(Level.INFO, "No se ha podido abrir la VentanaPago");
    		bd.closeLogger();
        }
      }
    });

    cp.add(panelPrincipal);

    panelPrincipal.add(panelLabel);
    panelPrincipal.add(panelMedio);

    panelLabel.add(labelTexto);

    panelMedio.add(panelIcono2);
    panelMedio.add(panelBoton2);

    panelIcono2.add(iconoI);

    panelBoton2.add(botonImprimir);

    this.pack();
    this.setTitle("Ticket");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setSize(250, 150);
  }

  // main de prueba
  public static void main(String[] args) {
    List<Actividad> listaActividades = new ArrayList<Actividad>();
    listaActividades.add(new Actividad("333333", "Surf", 55, "Juan", "Valencia", "dddddddddddddddddddd", "images/surf1", 44));

    new VentanaTicket(new Usuario("Andrea", "Martínez", "77485723H", "23874983274P", "andreamartinez", "asdjflkajsdf", "andrea21@gmail.com", 0, null), new Viaje("001S", "Madrid", "Valencia", "21/01/2022", 4, 10, null),  new Viaje("001S", "Madrid", "Valencia", "21/01/2022", 4, 10, null), 5, listaActividades);
  }
}