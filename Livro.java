import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Livro extends Publicacao {

    private int paginas;
    private String autores[];

    public Livro(String titulo, LocalDate data, int paginas, String... autores) {
        super(titulo, data);
        this.paginas = paginas;
        this.autores = autores;
    }

    public String[] getAutores() {
        return this.autores;
    }

    public int getPaginas() {
        return this.paginas;
    }

    @Override
    public boolean equals(Object obj) {
        Livro livro = null;
        try {
            livro = (Livro) obj;
        } catch (Exception exc) {
            return false;
        }
        return equals(livro.getTitulo(), livro.getData(), livro.getPaginas(), livro.getAutores());
    }

    public boolean equals(String titulo, LocalDate data, int paginas, String... autores) {
        if (this.getTitulo().equals(titulo) && this.getData().toString().equals(data.toString())
                && this.getPaginas() == paginas && this.getAutores()[0].equals(autores[0])) {
            return true;
        } else
            return false;
    }

    public String toString() {
        return "Livro: " + this.getTitulo() + " (" + this.getData().getYear() + ") - " + this.getPaginas()
                + " páginas - Autores: " + Arrays.stream(getAutores()).collect(Collectors.joining(", "));
    }
}