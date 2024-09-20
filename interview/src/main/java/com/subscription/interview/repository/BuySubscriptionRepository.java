package com.subscription.interview.repository;

import com.subscription.interview.model.BuySubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuySubscriptionRepository extends JpaRepository<BuySubscription, Long> {
    List<BuySubscription> findByUserId(Long userId);
}

