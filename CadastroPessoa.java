import java.util.*;
public class CadastroPessoa {
    private static final List<Pessoa> pessoas = new ArrayList<>();
    private static final Map<String, Pessoa> cpfToPessoaMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Consultar por CPF");
            System.out.println("3 - Listar todas as pessoas cadastradas");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPessoa(scanner);
                case 2 -> consultarPorCpf(scanner);
                case 3 -> listarPessoasCadastradas();
                case 4 -> {
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }

    private static void cadastrarPessoa(Scanner scanner) {
        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF da pessoa:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a idade da pessoa:");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o gênero da pessoa:");
        String genero = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, idade, genero);
        pessoas.add(pessoa);
        cpfToPessoaMap.put(cpf, pessoa);

        System.out.println("Pessoa cadastrada com sucesso!");
    }

    private static void consultarPorCpf(Scanner scanner) {
        System.out.println("Digite o CPF da pessoa que deseja consultar:");
        String cpf = scanner.nextLine();

        Pessoa pessoa = cpfToPessoaMap.get(cpf);

        if (pessoa != null) {
            System.out.println("Pessoa encontrada:");
            System.out.println(pessoa);
        } else {
            System.out.println("CPF não encontrado no sistema.");
        }
    }

    private static void listarPessoasCadastradas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        System.out.println("Pessoas cadastradas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
