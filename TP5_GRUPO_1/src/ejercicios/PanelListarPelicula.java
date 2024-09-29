package ejercicios;  

import javax.swing.*;  
import java.awt.*;  

public class PanelListarPelicula extends JPanel {  
    private static final long serialVersionUID = 1L;  
    private DefaultListModel<Pelicula> listaModel;  
    private JList<Pelicula> listaPeliculas;  

    public PanelListarPelicula(DefaultListModel<Pelicula> peliculas) {  
        setLayout(new FlowLayout(FlowLayout.LEFT)); 

        
        JLabel titulo = new JLabel("Películas");  
        titulo.setFont(new Font("Arial", Font.BOLD, 16));  
        add(titulo); // Añadir el título al panel  

       
        if (peliculas == null) {  
            this.listaModel = new DefaultListModel<>(); 
           
           
        } else {  
            this.listaModel = peliculas; 
        }  


        listaPeliculas = new JList<>(listaModel);  
        listaPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  

     
        JScrollPane scrollPane = new JScrollPane(listaPeliculas);  
        scrollPane.setPreferredSize(new Dimension(300, 200)); 
        add(scrollPane); 
    }  
}