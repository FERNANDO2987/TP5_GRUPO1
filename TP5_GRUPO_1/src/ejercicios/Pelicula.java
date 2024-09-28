package ejercicios;

public class Pelicula {
	
	private final int id;
	private String titulo;
	private Categoria categoria;
	private static int contador = 1;
	
	public Pelicula()
	{
		this.id = contador;
		contador++;
	}
	public Pelicula(int id, String titulo, Categoria categoria) {
		this.id = id;
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
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + "]";
	}
	
	public static int devuelveProximoID()
	{
		return contador;
	}
	
}
