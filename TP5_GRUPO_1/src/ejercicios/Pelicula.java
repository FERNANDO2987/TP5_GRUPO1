package ejercicios;

import java.util.Objects;

public class Pelicula implements Comparable<Pelicula> {
    
    private final int id;
    private String titulo;
    private Categoria categoria;
    private static int contador = 1;
    
    public Pelicula() {
        this.id = contador;
        contador++;
    }

    // Constructor con parámetros  
    public Pelicula(String titulo, Categoria categoria) {  
        this.id = contador++; // Asignar el contador y luego incrementarlo  
        this.titulo = titulo;  
        this.categoria = categoria;  
    }  
    
    // Constructor que aceptaba id, ahora no es necesario  
    public Pelicula(int id, String titulo, Categoria categoria) {  
        this.id = id; // Simplemente por si en algún momento se necesita un ID específico  
        this.titulo = titulo;  
        this.categoria = categoria;  
    }  

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  id + "-" + titulo + "-" + categoria;
    }

    public static int devuelveProximoID() {
        return contador;
    }

    @Override
    public int compareTo(Pelicula p) {

        return this.titulo.compareTo(p.titulo);
    }

  
    @Override
    public boolean equals(Object o)
    {
    	Pelicula objPelicula;
    	if(o instanceof Pelicula)
    	{
    		objPelicula = (Pelicula) o;
    		if(objPelicula.getId() == this.getId())
    		{
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public int hashCode() {
    
    	return Objects.hash(id, titulo, categoria);
    
    }
    
}
