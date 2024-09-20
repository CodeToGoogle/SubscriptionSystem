package com.subscription.interview.service;


import com.subscription.interview.model.BuySubscription;
import com.subscription.interview.model.SubscriptionMaster;
import com.subscription.interview.repository.BuySubscriptionRepository;
import com.subscription.interview.repository.SubscriptionMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionMasterRepository subscriptionMasterRepository;

    @Autowired
    private BuySubscriptionRepository buySubscriptionRepository;

    // Buy subscription
    public BuySubscription buySubscription(Long userId, Long subscriptionId) {
        SubscriptionMaster subscription = subscriptionMasterRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        LocalDate startDate = LocalDate.now();
        LocalDate endDate;

        if (subscription.getType().equalsIgnoreCase("Monthly")) {
            endDate = startDate.plusMonths(1);
        } else if (subscription.getType().equalsIgnoreCase("Yearly")) {
            endDate = startDate.plusYears(1);
        } else {
            throw new RuntimeException("Invalid subscription type");
        }

        BuySubscription buySubscription = new BuySubscription(userId, subscription, startDate, endDate);
        return buySubscriptionRepository.save(buySubscription);
    }

    // Get all subscriptions for a user
    public List<BuySubscription> getUserSubscriptions(Long userId) {
        return buySubscriptionRepository.findByUserId(userId);
    }
}
