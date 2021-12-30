package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BD;
import clases.Actividad;

import javax.swing.JTextPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaGaleria2 extends JFrame {

	private JPanel contentPane, panel_8, panelVolver, panel_16, panelFotos, panelGeneralFoto, panelIzq;
	private JTextField textFieldCod;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	BD bd = new BD();
	JLabel labelImagen;
	
	public VentanaGaleria2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 addWindowListener( new WindowAdapter() {
	            @Override
	            public void windowOpened(WindowEvent e) {
	            	verFoto();
	            }
	          
	        });
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		
		JTextPane textPaneGaleria = new JTextPane();
		textPaneGaleria.setEditable(false);
		textPaneGaleria.setText("Galeria de fotos");
		textPaneGaleria.setBackground(getForeground());
		textPaneGaleria.setFont(new Font("Consolas", Font.BOLD, 18));
		textPaneGaleria.setForeground(Color.DARK_GRAY);
		panelTitulo.add(textPaneGaleria);
		
		panelFotos = new JPanel();
		contentPane.add(panelFotos, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panelFotos.add(scrollPane);
		
		panelGeneralFoto = new JPanel();
		
		panelGeneralFoto.setLayout(new GridLayout(1,2)); 
		
		scrollPane.setViewportView(panelGeneralFoto);
		
		panelIzq = new JPanel();
		panelIzq.setLayout(new GridLayout(4,1)); 
		
		panelGeneralFoto.add(panelIzq);
		
		JPanel panelDch = new JPanel();
		panelDch.setLayout(new GridLayout(4,1));
		panelGeneralFoto.add(panelDch);
		
		JButton f1 = null;
		TreeSet<String> tsact;
		try {
			tsact = bd.obtenerDiferentesActividades();
			for(String f: tsact)
				f1 = new JButton(f);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelDch.add(f1);
		f1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				panelTitulo.setVisible(true);
				panelFotos.setVisible(false);
				panelVolver.setVisible(true);
				panel_8.setVisible(true);
			}
		});
		
		JLabel lfoto = new JLabel();
		
		panelVolver = new JPanel();
		contentPane.add(panelVolver, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				panelTitulo.setVisible(true);
				panelFotos.setVisible(true);
				panelVolver.setVisible(true);
				panel_8.setVisible(false);
			}
		});
		panelVolver.add(btnVolver);
		
		panel_8 = new JPanel();
		panel_8.setLayout(new GridLayout(1,2)); 
		contentPane.add(panel_8, BorderLayout.WEST);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(new GridLayout(6,1));
		panel_8.add(panel_15);
		
		JPanel panel_9 = new JPanel();
		panel_15.add(panel_9);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_9.add(lblNewLabel);
		
		textFieldCod = new JTextField();
		panel_9.add(textFieldCod);
		textFieldCod.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_15.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_10.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_10.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_15.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_11.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_11.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_15.add(panel_14);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_14.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel_14.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_15.add(panel_13);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_13.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel_13.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_15.add(panel_12);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_12.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_12.add(textField_3);
		textField_3.setColumns(10);
		
		panel_16 = new JPanel();
		panel_16.add(lfoto);
		panel_8.add(panel_16);
		
		panel_8.setVisible(false);
		
		setVisible(true);
		
		setSize(700,600);
	}

	public static void main(String[] args) {
		new VentanaGaleria2();
	}
	
	public void verFoto() {
		bd.connect();
		BufferedImage bufferedImage;
		ArrayList<Actividad> actividades = bd.getActividades();
		
		for (Actividad a : actividades) {
			try {
				bufferedImage = ImageIO.read(new File(a.getImagen()));
				Image image = bufferedImage.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
				labelImagen = new JLabel(new ImageIcon(image));
				panelIzq.add(labelImagen);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
		 bd.disconnect();
	}
	
}
