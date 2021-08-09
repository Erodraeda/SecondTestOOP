import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Impressao {

    private LocalDate data;
    private Publicacao publicacao;
    private String codigo;
    private static int numPubs = 0;

    public Impressao(Publicacao publicacao) {
        try {
            Livro livro = ((Livro) publicacao);
            this.codigo = "L" + numPubs;
        } catch (Exception ex) {
            this.codigo = "R" + numPubs;
        }
        // if (((Livro) publicacao).getAutores() != null || ((Livro)
        // publicacao).getPaginas() != 0) {
        // this.codigo = "L" + numPubs;
        // } else if (((Revista) publicacao).getEditora() != null || ((Revista)
        // publicacao).getEdicao() != 0) {
        // this.codigo = "R" + numPubs;
        // }
        this.data = LocalDate.now();
        this.publicacao = publicacao;
        numPubs++;
    }

    public Publicacao getPublicacao() {
        return this.publicacao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "exemplar: " + this.getCodigo() + "| Data impressão: " + dtf.format(this.getData()) + "\n"
                + this.publicacao.toString();

        // exemplar: R0| Data impressão: 29/03/2021\n
    }

}
