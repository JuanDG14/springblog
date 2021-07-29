package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository<Ad, Long> {
    @Query("FROM Ad a WHERE a.id = ?1")
    Ad findById(long id);

    @Query("FROM Ad a WHERE a.title LIKE %:term%")
    Ad findByTitle(String term);
}