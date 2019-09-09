package com.hsbc.demo.repository;

import com.hsbc.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByOrderByCreatedTimeAsc();
    List <Post> findByUserIdOrderByCreatedTimeDesc(Long userId);

}
