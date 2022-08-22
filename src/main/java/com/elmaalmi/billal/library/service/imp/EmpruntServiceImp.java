package com.elmaalmi.billal.library.service.imp;

import com.elmaalmi.billal.library.dal.EmpruntRepository;
import com.elmaalmi.billal.library.exception.NotFoudException;
import com.elmaalmi.billal.library.model.*;
import com.elmaalmi.billal.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpruntServiceImp implements EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository;
    @Autowired
    private AdherentService adherentService;
    @Autowired
    private LivreService livreService;
    @Autowired
    private RevueService revueService;
    @Autowired
    private DictionnaireService dictionnaireService;
    @Override
    public void save(Emprunt o) {
        /*Adherent adherent = adherentService.findById(o.getAdherent().getId());
        o.setAdherent(adherent);
        if(o.getLivre().getId() != 0){
            Livre livre = livreService.findById(o.getLivre().getId());
            o.setLivre(livre);
        }
        if(o.getRevue().getId() !=0){
            Revue revue = revueService.findById(o.getRevue().getId());
            o.setRevue(revue);
        }
        if(o.getDictionnaire().getId() != 0){
            Dictionnaire dictionnaire = dictionnaireService.findById(o.getDictionnaire().getId());
            o.setDictionnaire(dictionnaire);
        }*/
        System.out.println(o);
        empruntRepository.save(o);
    }

    @Override
    public void update(Emprunt o) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Emprunt findById(long id) {
        return empruntRepository.findById(id).orElseThrow(()-> new NotFoudException("emprunt not found with id :"+id));
    }

    @Override
    public List<Emprunt> findAll() {
        return empruntRepository.findAll();
    }
}
