package com.elmaalmi.billal.library.service.imp;

import com.elmaalmi.billal.library.dal.RevueRepository;
import com.elmaalmi.billal.library.exception.NotFoudException;
import com.elmaalmi.billal.library.model.Revue;
import com.elmaalmi.billal.library.service.RevueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RevueServiceImp implements RevueService {
    @Autowired
    private RevueRepository revueRepository;
    @Override
    public void save(Revue o) {
        revueRepository.save(o);
    }

    @Override
    public void update(Revue o) {

    }

    @Override
    public void delete(long id) {
        Revue revue = revueRepository.findById(id).orElseThrow(()->new NotFoudException("Revue not found with id : "+id));
        revueRepository.delete(revue);
    }

    @Override
    public Revue findById(long id) {
        return revueRepository.findById(id).orElseThrow(()->new NotFoudException("Revue not found with id : "+id));
    }

    @Override
    public List<Revue> findAll() {
        return revueRepository.findAll();
    }
}
