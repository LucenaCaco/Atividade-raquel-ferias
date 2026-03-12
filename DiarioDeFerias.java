import java.util.List;
import java.util.Scanner;

public class DiarioDeFerias {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MeuDiarioDeFerias diario = new MeuDiarioDeFerias();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n=== Diário de Férias ===");
            System.out.println("1 - Adicionar atividade");
            System.out.println("2 - Listar atividades");
            System.out.println("3 - Pesquisar por tag");
            System.out.println("4 - Listar por nota");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            try {

                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();

                        System.out.print("Nota (0 a 10): ");
                        double nota = Double.parseDouble(sc.nextLine());

                        System.out.print("Tag: ");
                        String tag = sc.nextLine();

                        AtividadeDeFerias atividade = new AtividadeDeFerias(descricao, nota, tag);
                        diario.adicionarAtividade(atividade);

                        System.out.println("Atividade adicionada!");
                        break;

                    case 2:

                        if (diario.estaVazio()) {
                            System.out.println("Nenhuma atividade cadastrada.");
                        } else {

                            for (AtividadeDeFerias a : diario.listarAtividades()) {
                                System.out.println(a);
                            }
                        }

                        break;

                    case 3:

                        if (diario.estaVazio()) {
                            System.out.println("Diário vazio.");
                            break;
                        }

                        System.out.print("Digite a tag: ");
                        String busca = sc.nextLine();

                        List<AtividadeDeFerias> resultado = diario.pesquisarPorTag(busca);

                        if (resultado.isEmpty()) {
                            System.out.println("Nenhuma atividade encontrada.");
                        } else {
                            for (AtividadeDeFerias a : resultado) {
                                System.out.println(a);
                            }
                        }

                        break;

                    case 4:

                        if (diario.estaVazio()) {
                            System.out.println("Diário vazio.");
                        } else {

                            List<AtividadeDeFerias> ordenado = diario.ordenarPorNota();

                            for (AtividadeDeFerias a : ordenado) {
                                System.out.println(a);
                            }
                        }

                        break;

                    case 5:
                        System.out.println("Encerrando programa...");
                        break;

                    default:
                        System.out.println("Opção inválida.");

                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        sc.close();
    }
}