package com.springboot.repository;

import com.springboot.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    @Query(value = "SELECT a.* " +
            "         FROM credit_card a, " +
            "              (select id from credit_card order by id limit 2) b " +
            "        where a.id = b.id ", nativeQuery = true)
    List<CreditCard> findAllWithCoveringIndex();
    List<CreditCard> findTop2ByOrderByIdAsc();
}
