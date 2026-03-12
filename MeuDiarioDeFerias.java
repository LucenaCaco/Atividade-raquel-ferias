import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeuDiarioDeFerias {

    private List<AtividadeDeFerias> atividades;

    public MeuDiarioDeFerias() {
        atividades = new ArrayList<>();
    }

    public void adicionarAtividade(AtividadeDeFerias atividade) {
        atividades.add(atividade);
    }

    public List<AtividadeDeFerias> listarAtividades() {
        return atividades;
    }

    public List<AtividadeDeFerias> pesquisarPorTag(String tag) {
        List<AtividadeDeFerias> resultado = new ArrayList<>();

        for (AtividadeDeFerias a : atividades) {
            if (a.getTag().equalsIgnoreCase(tag)) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    public List<AtividadeDeFerias> ordenarPorNota() {
        List<AtividadeDeFerias> copia = new ArrayList<>(atividades);

        copia.sort(Comparator.comparingDouble(AtividadeDeFerias::getNota).reversed());

        return copia;
    }

    public boolean estaVazio() {
        return atividades.isEmpty();
    }
}