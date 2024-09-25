package ejercicios;

public class Pelicula {
	
	private int id;
	private String titulo;
	private Categoria categoria;
	
	public Pelicula()
	{
		
	}
	public Pelicula(int id, String titulo, Categoria categoria) {
		this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
}
