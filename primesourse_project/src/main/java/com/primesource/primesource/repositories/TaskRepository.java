package com.primesource.primesource.repositories;


import com.primesource.primesource.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Tasks,Long> {

    @Query("UPDATE Tasks t " +
            "SET t.done= TRUE WHERE t.id = ?1")
    int setDone(Long id);
}
