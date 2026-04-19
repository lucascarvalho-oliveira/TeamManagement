package model;

public class Goleiro extends Jogador{
    private int nro_defesas;

    public Goleiro(String nome, String dataNascimento, int nro_defesas){
        super(nome, dataNascimento);

        this.nro_defesas = nro_defesas;
    }

    @Override
    public int numero(){
        return nro_defesas;
    }

    @Override
    public String toString(){
        return "Goleiro;" + nome + ";" + dataNascimento + ";" + nro_defesas;
    }
}
