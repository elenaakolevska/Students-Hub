package com.studentshub.repository;

import com.studentshub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>,JpaSpecificationRepository<Favorite,Long> {
    List<Favorite> findByUser(User user);
}