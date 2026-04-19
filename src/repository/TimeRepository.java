package repository;

import model.Atacante;
import model.Goleiro;
import model.Jogador;
import model.Time;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class TimeRepository {

    public void salvarTime(Time time){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Time.txt", true))){

            String linha = time.getIdentificador() + ";" + time.getNome() + ";";

            for(Jogador j: time.getJogadores()){
                linha += j.toString() + "|";
            }

            writer.write(linha);
            writer.newLine();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Map<Integer, Time> buscarTime(){
        Map<Integer, Time> mapaTime = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("Time.txt"))){
            String linha;

            while((linha = reader.readLine()) != null){
                String[] partes = linha.split(";");

                if(partes.length >= 2){
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];

                    Time time = new Time(nome, id);

                    if(partes.length > 2){
                        String[] jogadoresString = partes[2].split("\\|");

                        for(String dados : jogadoresString){
                            if(dados.isEmpty()) continue;

                            String[] d = dados.split(";");
                            String tipo = d[0];

                            if(tipo.equals("Atacante")){
                                time.getJogadores().add(new Atacante(d[1], d[2], Integer.parseInt(d[3])));
                            }
                            if(tipo.equals("Goleiro")){
                                time.getJogadores().add(new Goleiro(d[1], d[2], Integer.parseInt(d[3])));
                            }
                        }
                    }
                    mapaTime.put(id, time);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return mapaTime;
    }
}
