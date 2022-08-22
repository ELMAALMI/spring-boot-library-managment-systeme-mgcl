package com.elmaalmi.billal.library.dal;

import com.elmaalmi.billal.library.model.Dictionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionnaireRepository extends JpaRepository<Dictionnaire,Long> {
}
