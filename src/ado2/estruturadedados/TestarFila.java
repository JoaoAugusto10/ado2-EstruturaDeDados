package ado2.estruturadedados;

import java.util.Scanner ;

public class TestarFila {

    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU DE ATENDIMENTO ---");
            System.out.println("1. Solicitar senha");
            System.out.println("2. Chamar próxima senha");
            System.out.println("3. Ver próxima senha");
            System.out.println("4. Listar todas as senhas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Solicitar senha preferencial? (true/false): ");
                    boolean preferencial = scanner.nextBoolean();
                    fila.solicitarSenha(preferencial);
                    break;

                case 2:
                    fila.chamarProximaSenha();
                    break;

                case 3:
                    fila.verProximaSenha();
                    break;

                case 4:
                    fila.listarSenhas();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
