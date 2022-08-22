package com.elmaalmi.billal.library;

import com.elmaalmi.billal.library.dal.AdherentRepository;
import com.elmaalmi.billal.library.model.Adherent;
import com.elmaalmi.billal.library.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitData implements CommandLineRunner {
    @Autowired private AdherentRepository adherentRepository;
    @Override
    public void run(String... args) throws Exception {
        Adherent adherent = Adherent.builder()
                .nom("el maalmi")
                .prenom("billal")
                .adresse("29 Marjane 4")
                .cin("D87777")
                .date_naissance(new Date()).build();
        Adherent adherent1 = Adherent.builder()
                .nom("el maalmi")
                .prenom("ayoub")
                .adresse("29 Marjane 4")
                .cin("D87789")
                .date_naissance(new Date()).build();
        Adherent adherent2 = Adherent.builder()
                .nom("el maalmi")
                .prenom("Meryem")
                .adresse("29 Marjane 4")
                .cin("D878117")
                .date_naissance(new Date()).build();
        adherentRepository.deleteAll();
        adherentRepository.save(adherent);
        adherentRepository.save(adherent1);
        adherentRepository.save(adherent2);
    }
}
