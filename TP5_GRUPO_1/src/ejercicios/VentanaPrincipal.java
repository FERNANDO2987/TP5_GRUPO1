package ejercicios;

import java.awt.BorderLayout;  
 
import java.util.ArrayList;  
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.border.EmptyBorder;  
import javax.swing.JMenuBar;  
import javax.swing.JMenu;  
import javax.swing.JMenuItem;  
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;  

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private List<String> peliculas; // Lista para almacenar las películas  
	 private DefaultListModel<Pelicula> modeloLista;  
	 
	public VentanaPrincipal() {
		
		 // Inicializamos la lista de películas  
        peliculas = new ArrayList<>();  
        // Agregamos algunas películas de ejemplo  
        peliculas.add("Inception");  
        peliculas.add("Interstellar");  
        peliculas.add("The Matrix"); 
		
        modeloLista = new DefaultListModel<>();
        
   
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeliculas  = new JMenu("Pel\u00EDculas");
		menuBar.add(mnPeliculas );
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				PanelAgregarPelicula panelAgregarPelicula = new PanelAgregarPelicula(modeloLista);
				contentPane.add(panelAgregarPelicula);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		
		mnPeliculas .add(mntmAgregar);
		
		
		  JMenuItem mntmListar = new JMenuItem("Listar");  
	        mntmListar.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent e) {  
	                contentPane.removeAll(); // Limpiar el panel actual  
	                PanelListarPelicula panelListarPelicula = new PanelListarPelicula(modeloLista); 
	                contentPane.add(panelListarPelicula); // Añadir el panel de listar  
	                contentPane.repaint();  
	                contentPane.revalidate(); // Actualizar la vista  
	            }  
	        });  
	        mnPeliculas.add(mntmListar); 
	        
	
	        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
    	//Iniciializa con un panel por defecto
		mntmAgregar.doClick();
		
	
	}
	
	public void cambiarVisibilidad(boolean estado)
	{
		setVisible(estado);
	}
}
