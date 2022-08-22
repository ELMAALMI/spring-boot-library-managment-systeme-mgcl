package com.elmaalmi.billal.library.dal;

import com.elmaalmi.billal.library.model.Revue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevueRepository extends JpaRepository<Revue,Long> {
}
