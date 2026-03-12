import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaPOO {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<user> usuarios = new ArrayList<user>();
    static ArrayList<livro> livros = new ArrayList<livro>();

    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("= Bem Vindo a Biblioteca =");
        System.out.println("==========================");

        boolean rodando = true;
        while (rodando) {

            System.out.println("    ");
            System.out.println("========== MENU ==========");
            System.out.println("=   1.   Listar livros   =");
            System.out.println("=   2.  Cadastrar livro  =");
            System.out.println("=   3.  Emprestar livro  =");
            System.out.println("=   4.  Devolver livro   =");
            System.out.println("=   5.  Listar usuários  =");
            System.out.println("=   6. Cadastrar usuário =");
            System.out.println("=   0.       Sair        =");
            System.out.println("==========================");

            System.out.print("Escolha uma opção: ");
            String opcao = ler.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.println("= Livros cadastrados: =");
                    livros.forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("Insira os dados solicitados para realizar o cadastro de usuario");

                    System.out.println("Insira o nome do livro: ");
                    String titulo = ler.nextLine().trim();

                    System.out.println("Insira o nome do autor do livro: ");
                    String autor = ler.nextLine().trim();
                    livro novolivr = new livro(titulo, autor); // id nao listado pois é gerado aleatoriamente no
                                                               // livro.java
                    livros.add(novolivr); // lê informações preenchidas e armazena elas
                    break;
                case "3":

                emprestarLivro();

                    break;
                case "4":

                devolverLivro();
                
                    break;
                case "5":
                    System.out.println("= Usuarios cadastrados: =");
                    usuarios.forEach(System.out::println); // busca dados salvos anteriormente por via de cadastro e os
                                                           // imprime
                    break;
                case "6":
                    System.out.println("Insira os dados solicitados para realizar o cadastro de usuario");

                    System.out.println("Insira seu nome: ");
                    String nome = ler.nextLine().trim();

                    String cpf;

                    while (true) {

                        System.out.println("Insira seu cpf: ");
                        cpf = ler.nextLine().trim();

                        if (cpf.length() == 11) {
                            break;
                        }

                        System.out.println("CPF inválido! Digite exatamente 11 números.");
                    } // verifica se a quantidade de caracteres inseridos esta correta e se nao
                      // estiver, volta o codigo a parte de inserir

                    String telefone;

                    while (true) {

                        System.out.println("Insira seu numero de telefone: ");
                        telefone = ler.nextLine().trim();

                        if (telefone.length() == 11) {
                            break;
                        }
                        System.out.println(
                                "Numero inválido! Deve conter 11 caracteres (contanto com prefixo). Ex: 11912345678");
                    } // mesma coisa do coiso do cpf

                    user novousuario = new user(nome, cpf, telefone);
                    usuarios.add(novousuario);
                    break;
                case "0":
                    System.out.println("Até a próxima!");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    public static void emprestarLivro() {

        System.out.println("Digite o ID do livro:");
        String codigo = scanner.nextLine();

        for (livro l : livros) {

            if (l.getId().equals(codigo)) {

                if (l.foiEmprestado()) {
                    System.out.println("Livro já está emprestado!");
                } else {
                    l.emprestar();
                    System.out.println("Livro emprestado com sucesso!");
                }

                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    public static void devolverLivro() {

        System.out.println("Digite o ID do livro:");
        String codigo = scanner.nextLine();

        for (livro l : livros) {

            if (l.getId().equals(codigo)) {

                if (!l.foiEmprestado()) {
                    System.out.println("Esse livro já está disponível!");
                } else {
                    l.devolver();
                    System.out.println("Livro devolvido com sucesso!");
                }

                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

}
