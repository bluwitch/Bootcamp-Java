package com.bootcamp.students.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.students.models.Info;

@Repository
public interface InfoRepository extends CrudRepository<Info, Long> {
    List<Info> findAll();

    @Query("SELECT i FROM Info i LEFT OUTER JOIN FETCH i.student")
    List<Info> allInfos();
}