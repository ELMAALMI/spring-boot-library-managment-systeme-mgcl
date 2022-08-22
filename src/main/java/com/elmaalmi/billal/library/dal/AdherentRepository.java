package com.elmaalmi.billal.library.dal;

import com.elmaalmi.billal.library.model.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent,Long> {
    Optional<Adherent> findByCinAndIdIsNot(String cin,long id);
}
