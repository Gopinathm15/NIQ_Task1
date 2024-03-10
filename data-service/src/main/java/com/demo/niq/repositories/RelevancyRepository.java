package com.demo.niq.repositories;

import com.demo.niq.domain.Relevancy;
import com.demo.niq.domain.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelevancyRepository extends JpaRepository<Relevancy, Long> {
    @Query("FROM Relevancy r WHERE r.shopperInfo=:shopperId")
    List<Shopper> findByShopperId(@Param("shopperId") String shopperId);
}
