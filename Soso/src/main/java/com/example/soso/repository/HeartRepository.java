package com.example.soso.repository;


import com.example.soso.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByPostId(Long postId);
    Optional<Heart> findByMemberId(Long memberId);
}