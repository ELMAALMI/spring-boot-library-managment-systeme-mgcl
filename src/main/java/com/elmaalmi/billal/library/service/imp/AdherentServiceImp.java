package com.elmaalmi.billal.library.service.imp;

import com.elmaalmi.billal.library.dal.AdherentRepository;
import com.elmaalmi.billal.library.exception.BadRequestException;
import com.elmaalmi.billal.library.exception.NotFoudException;
import com.elmaalmi.billal.library.model.Adherent;
import com.elmaalmi.billal.library.service.AdherentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdherentServiceImp implements AdherentService {
    @Autowired
    private AdherentRepository adherentRepository;
    @Override
    public void save(Adherent o) {
        Optional<Adherent> check_adherent_cin = adherentRepository.findByCinAndIdIsNot(o.getCin(),o.getId());
        if(check_adherent_cin.isPresent()){
            throw new BadRequestException("cin deja enregister");
        }
        adherentRepository.save(o);
    }

    @Override
    public void update(Adherent o) {
        Optional<Adherent> check_adherent_id = adherentRepository.findById(o.getId());
        if(!check_adherent_id.isPresent()){
            throw new NotFoudException("adherent Not found");
        }
        Optional<Adherent> check_adherent_cin = adherentRepository.findByCinAndIdIsNot(o.getCin(), o.getId());
        if(check_adherent_cin.isPresent()){
            throw new BadRequestException("cin deja enregister");
        }
        BeanUtils.copyProperties(o,check_adherent_id.get());
        adherentRepository.save(check_adherent_id.get());
    }

    @Override
    public void delete(long id) {
        Optional<Adherent> check_adherent_cin = adherentRepository.findById(id);
        if(!check_adherent_cin.isPresent()){
            throw new NotFoudException("adherent Not found");
        }
        adherentRepository.delete(check_adherent_cin.get());
    }

    @Override
    public Adherent findById(long id) {
        return adherentRepository.findById(id).orElseThrow(()->new NotFoudException("Adherent not Found with id : "+id));
    }

    @Override
    public List<Adherent> findAll() {
        return adherentRepository.findAll();
    }
}
