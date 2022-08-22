package com.elmaalmi.billal.library.dal;

import com.elmaalmi.billal.library.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {
}
