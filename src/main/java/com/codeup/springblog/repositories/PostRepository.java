package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
        @Query("FROM Post a WHERE a.id = ?1")
        Post findById(long id);

        @Query("FROM Post a WHERE a.title LIKE %:term%")
        Post findFirstByTitle(String term);
}
