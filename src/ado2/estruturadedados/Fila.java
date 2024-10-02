package ado2.estruturadedados;

public class Fila {
    private Paciente[] filaComum;
    private Paciente[] filaPreferencial;
    private int qtdComum;
    private int qtdPreferencial;
    private int senhaAtual;
    private int contadorAtendimentoPreferencial;

    public Fila() { 
        filaComum = new Paciente[100];         // Fila para pacientes comuns
        filaPreferencial = new Paciente[100];  // Fila para pacientes preferenciais
        qtdComum = 0;
        qtdPreferencial = 0;
        senhaAtual = 1;
        contadorAtendimentoPreferencial = 0;
    }

    // Método para solicitar uma nova senha
    public void solicitarSenha(boolean preferencial) {
        if (preferencial) {
            filaPreferencial[qtdPreferencial++] = new Paciente(senhaAtual++, true);
            System.out.println("Senha preferencial solicitada com sucesso!");
        } else {
            filaComum[qtdComum++] = new Paciente(senhaAtual++, false);
            System.out.println("Senha comum solicitada com sucesso!");
        }
    }

    // Método para listar todas as senhas
    public void listarSenhas() {
        System.out.println("Senhas preferenciais:");
        for (int i = 0; i < qtdPreferencial; i++) {
            System.out.println(filaPreferencial[i]);
        }
        System.out.println("Senhas comuns:");
        for (int i = 0; i < qtdComum; i++) {
            System.out.println(filaComum[i]);
        }
    }

    // Método para visualizar o próximo paciente a ser atendido
    public void verProximaSenha() {
        if (deveAtenderComum()) {
            if (qtdComum > 0) {
                System.out.println("Próxima senha comum: " + filaComum[0]);
            } else {
                System.out.println("Nenhum paciente comum na fila.");
            }
        } else {
            if (qtdPreferencial > 0) {
                System.out.println("Próxima senha preferencial: " + filaPreferencial[0]);
            } else if (qtdComum > 0) {
                System.out.println("Próxima senha comum: " + filaComum[0]);
            } else {
                System.out.println("Nenhum paciente na fila.");
            }
        }
    }

    // Método para chamar o próximo paciente
    public void chamarProximaSenha() {
        if (deveAtenderComum()) {
            if (qtdComum > 0) {
                System.out.println("Chamando senha comum: " + filaComum[0]);
                excluirSenha(false);
            } else {
                System.out.println("Nenhum paciente comum na fila.");
            }
        } else {
            if (qtdPreferencial > 0) {
                System.out.println("Chamando senha preferencial: " + filaPreferencial[0]);
                excluirSenha(true);
            } else if (qtdComum > 0) {
                System.out.println("Chamando senha comum: " + filaComum[0]);
                excluirSenha(false);
            } else {
                System.out.println("Nenhum paciente na fila.");
            }
        }
    }

    // Método para excluir a primeira senha da fila
    public void excluirSenha(boolean preferencial) {
        if (preferencial) {
            for (int i = 0; i < qtdPreferencial - 1; i++) {
                filaPreferencial[i] = filaPreferencial[i + 1];
            }
            filaPreferencial[--qtdPreferencial] = null;
            contadorAtendimentoPreferencial++;
        } else {
            for (int i = 0; i < qtdComum - 1; i++) {
                filaComum[i] = filaComum[i + 1];
            }
            filaComum[--qtdComum] = null;
            contadorAtendimentoPreferencial = 0; // Zera o contador de atendimentos preferenciais
        }
    }

    // Verifica se o próximo atendimento deve ser para um paciente comum
    private boolean deveAtenderComum() {
        return contadorAtendimentoPreferencial == 3 || qtdPreferencial == 0;
    }
}
