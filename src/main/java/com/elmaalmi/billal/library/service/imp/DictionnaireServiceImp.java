package com.elmaalmi.billal.library.service.imp;

import com.elmaalmi.billal.library.dal.DictionnaireRepository;
import com.elmaalmi.billal.library.exception.NotFoudException;
import com.elmaalmi.billal.library.model.Dictionnaire;
import com.elmaalmi.billal.library.service.DictionnaireService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionnaireServiceImp implements DictionnaireService {
    @Autowired
    private DictionnaireRepository dictionnaireRepository;
    @Override
    public void save(Dictionnaire o) {
        dictionnaireRepository.save(o);
    }
    @Override
    public void update(Dictionnaire o) {
        Dictionnaire dictionnaire = dictionnaireRepository.findById(o.getId())
                .orElseThrow(()->new NotFoudException("document not found with id : "+o.getId()));
        BeanUtils.copyProperties(o,dictionnaire);
        dictionnaireRepository.save(dictionnaire);
    }

    @Override
    public void delete(long id) {
        Dictionnaire dictionnaire = dictionnaireRepository.findById(id)
                .orElseThrow(()->new NotFoudException("document not found with id : "+id));
        dictionnaireRepository.delete(dictionnaire);
    }

    @Override
    public Dictionnaire findById(long id) {
        return dictionnaireRepository.findById(id)
                .orElseThrow(()->new NotFoudException("document not found with id : "+id));
    }

    @Override
    public List<Dictionnaire> findAll() {
        System.out.println(dictionnaireRepository.findAll().size());
        return dictionnaireRepository.findAll();
    }
}
