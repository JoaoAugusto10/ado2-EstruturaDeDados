package ado2.estruturadedados;

public class Paciente {
    private int senha;
    private boolean preferencial;

    public Paciente(int senha, boolean preferencial) {
        this.senha = senha;
        this.preferencial = preferencial;
    }

    public int getSenha() {
        return senha;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    @Override 
    public String toString() {
        return "Paciente{" +
                "senha=" + senha +
                ", preferencial=" + preferencial +
                '}';
    }
}
