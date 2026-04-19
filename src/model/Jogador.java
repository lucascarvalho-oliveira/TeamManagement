package model;

public class Jogador {
    protected String nome;
    protected String dataNascimento;

    public Jogador(){}

    public Jogador(String nome, String dataNascimento){
       this.nome = nome;
       this.dataNascimento = dataNascimento;

        ehValido();
    }

    public void ehValido(){
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do jogador invalido");
        }
        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            throw new IllegalArgumentException("Data de nascimento incorreto");
        }
    }

    public String getNome(){
        return nome;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public int numero(){
        return 0;
    }

    public String toString(){
        return nome;
    }
}
