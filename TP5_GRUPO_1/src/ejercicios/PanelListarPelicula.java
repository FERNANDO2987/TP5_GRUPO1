package ejercicios;  

import javax.swing.*;  
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;  

public class PanelListarPelicula extends JPanel {  
    private static final long serialVersionUID = 1L;  
    private DefaultListModel<Pelicula> listaModel;  
    private JList<Pelicula> listaPeliculas;  

    public PanelListarPelicula(DefaultListModel<Pelicula> peliculas) {  
        setLayout(new FlowLayout(FlowLayout.LEFT)); 

        
        JLabel titulo = new JLabel("Películas");  
        titulo.setFont(new Font("Arial", Font.BOLD, 16));  
        add(titulo); // Añadir el título al panel  

        
        this.listaModel = peliculas;  

        listaPeliculas = new JList<>(listaModel);  
        listaPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  

     
        JScrollPane scrollPane = new JScrollPane(listaPeliculas);  
        scrollPane.setPreferredSize(new Dimension(300, 200)); 
        add(scrollPane); 
        
        ordenarLista();
        
        
        
    }  
    
    public void agregarPelicula(Pelicula nuevaPelicula)
    {
    	
    	listaModel.addElement(nuevaPelicula);
    	ordenarLista();
    }
    
    
    private void ordenarLista()
    {
    	ArrayList<Pelicula> peliculaList = new ArrayList<>();
    	
    	
    	for(int i=0; i<listaModel.getSize(); i++)
    	{
    		
    		peliculaList.add(listaModel.getElementAt(i));
    	}
    	
    	  Collections.sort(peliculaList, Comparator.comparing(Pelicula::getTitulo));
    	  
    	  listaModel.clear();
    	  
    	  for(Pelicula pelicula : peliculaList)
    	  {
    		  listaModel.addElement(pelicula);
    		  
    	  }
    	  
    	
    }
}