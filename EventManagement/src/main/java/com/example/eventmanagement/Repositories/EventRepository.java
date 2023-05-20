package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events,Long> {
    @Override
    List<Events> findAll();
    @Override
    Events save(Events events);
    @Override
    void delete(Events event);
    Events findById(long id);

    @Query("select e from Events e where e.user.userid = :userId")
    List<Events> findByUserId(@Param("userId") Integer userId);

}
