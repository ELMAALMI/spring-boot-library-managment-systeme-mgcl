package com.elmaalmi.billal.library.service.imp;

import com.elmaalmi.billal.library.dal.LivreRepository;
import com.elmaalmi.billal.library.exception.NotFoudException;
import com.elmaalmi.billal.library.model.Livre;
import com.elmaalmi.billal.library.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImp implements LivreService {
    @Autowired private LivreRepository livreRepository;
    @Override
    public void save(Livre o) {
        livreRepository.save(o);
    }

    @Override
    public void update(Livre o) {

    }

    @Override
    public void delete(long id) {
        Livre livre = livreRepository.findById(id).orElseThrow(()->new NotFoudException("Book not found with id : "+id));
        livreRepository.delete(livre);
    }

    @Override
    public Livre findById(long id) {
        return livreRepository.findById(id).orElseThrow(()->new NotFoudException("Book not found with id : "+id));
    }

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }
}
