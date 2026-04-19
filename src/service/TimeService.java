package service;

import repository.TimeRepository;
import model.Time;

public class TimeService {
    private TimeRepository repository;

    public TimeService(TimeRepository repository){
        this.repository = repository;
    }

    public void salvarTime(Time time) {
       time.validar();

        if (time.getJogadores().size() > 11) {
            throw new IllegalArgumentException("Máximo de 11 jogadores");
        }

        this.repository.salvarTime(time);
    }
}
