package com.elmaalmi.billal.library.dal;

import com.elmaalmi.billal.library.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre,Long> {
}
