import java.util.ArrayList;

public class Livraria {

    private String nome;
    private ArrayList<Impressao> estoque;

    public Livraria(String nome) {
        this.nome = nome;
        estoque = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public int getExemplares(Publicacao publicacao) {
        int counter = 0;
        for (Impressao i : estoque) {
            if (i.getPublicacao().equals(publicacao)) {
                counter++;
            }
        }
        return counter;
    }

    public void addEstoque(Publicacao publicacao) {
        estoque.add(new Impressao(publicacao));
    }

    public void addEstoque(Publicacao publicacao, int x) {
        for (int i = 0; i < x; i++) {
            estoque.add(new Impressao(publicacao));
        }
    }

    public Impressao vende(Publicacao publicacao) {
        for (Impressao i : estoque) {
            if (i.getPublicacao().equals(publicacao)) {
                estoque.remove(i);
                return i;
            }
        }
        return null;
    }

}
