package com.subscription.interview.repository;




import com.subscription.interview.model.BuySubscription;
import com.subscription.interview.model.SubscriptionMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionMasterRepository extends JpaRepository<SubscriptionMaster, Long> {
}


