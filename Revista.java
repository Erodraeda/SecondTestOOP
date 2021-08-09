import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Revista extends Publicacao {

    private int edicao;
    private String editora;

    public Revista(String titulo, LocalDate data, String editora, int edicao) {
        super(titulo, data);
        this.edicao = edicao;
        this.editora = editora;
    }

    public int getEdicao() {
        return this.edicao;
    }

    public String getEditora() {
        return this.editora;
    }

    @Override
    public boolean equals(Object obj) {
        Revista revista = null;
        try {
            revista = (Revista) obj;
        } catch (Exception exc) {
            return false;
        }
        return equals(revista.getTitulo(), revista.getData(), revista.getEdicao(), revista.getEditora());
    }

    public boolean equals(String titulo, LocalDate data, int edicao, String editora) {
        if (this.getTitulo().equals(titulo) && this.getData().toString().equals(data.toString())
                && this.getEdicao() == edicao && this.getEditora().equals(editora)) {
            return true;
        } else
            return false;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/yyyy");
        return "Revista: " + this.getTitulo() + " (" + dtf.format(this.getData()) + ") - editora " + this.getEditora()
                + " - edição n°:" + getEdicao();
    }

}
