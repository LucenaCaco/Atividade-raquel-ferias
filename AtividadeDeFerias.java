import java.util.Objects;

public class AtividadeDeFerias {

    private String descricao;
    private double nota;
    private String tag;

    public AtividadeDeFerias(String descricao, double nota, String tag) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
        this.descricao = descricao;
        this.nota = nota;
        this.tag = tag;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getNota() {
        return nota;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao +
                " | Nota: " + nota +
                " | Tag: " + tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtividadeDeFerias)) return false;
        AtividadeDeFerias that = (AtividadeDeFerias) o;
        return Double.compare(that.nota, nota) == 0 &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, nota, tag);
    }
}